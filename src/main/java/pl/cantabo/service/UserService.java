package pl.cantabo.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.cantabo.database.user.UserDAO;
import pl.cantabo.database.user.UserRepository;
import pl.cantabo.database.user.UserType;
import pl.cantabo.utils.TokenUtility;
import pl.cantabo.validator.UserValidator;

import javax.validation.ValidationException;
import java.time.ZonedDateTime;
import java.util.List;
import java.util.UUID;

@Service
@Log4j2
@RequiredArgsConstructor
public class UserService {

    @Value("${app.user.token.activation.validity-days:7}")
    private int tokenValidity;
    private final UserRepository userRepository;
    private final UserValidator userValidator;

    @Transactional
    public UserDAO create(UserDAO user) {
        log.debug("Creating user {}", user);

        userValidator.validateUser(user, false);

        user.setToken(TokenUtility.generate());
        user.setTokenExpiration(ZonedDateTime.now().plusDays(tokenValidity));

        userValidator.parseUserType(user);

        return log.traceExit(userRepository.save(user));
    }

    @Transactional
    public UserDAO update(UUID id, UserDAO user) {
        log.debug("Editing user {} - {}", id, user);
        boolean isSameUser = userValidator.checkIfSameUser(id, user);
        userValidator.validateUser(user, isSameUser);
        UserDAO toUpdate = userRepository.findById(id)
                .orElseThrow(() -> new ValidationException("User with id " + id + " was not found"));

        toUpdate.setName(user.getName());
        toUpdate.setEmail(user.getEmail());
        toUpdate.setPassword(user.getPassword());
        toUpdate.setActive(user.getActive());
        toUpdate.setGroup(user.getGroup());
        toUpdate.setToken(user.getToken());
        toUpdate.setTokenExpiration(user.getTokenExpiration());

        userValidator.parseUserType(toUpdate);

        return log.traceExit(userRepository.save(toUpdate));
    }

    public void delete(UUID id) {
        isSuperAdmin(id);
        log.debug("Deleting user {}", id);
        userRepository.deleteById(id);
    }

    public void isSuperAdmin(UUID id) {
        UserDAO user = userRepository.findById(id)
                .orElseThrow(() -> new ValidationException("User with id " + id + " was not found"));
        if (user.getUserType() == UserType.SUPER_ADMINISTRATOR) {
            throw new ValidationException("Nie można usunąć super administratora");
        }
    }

    public List<UserDAO> getAll() {
        log.debug("Getting all users");
        return log.traceExit(userRepository.findAll());
    }

    public List<UserType> getAllUserTypes() {
        log.debug("Getting all user types");
        return log.traceExit(List.of(UserType.values()));
    }
}
