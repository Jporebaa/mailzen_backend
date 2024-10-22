package pl.cantabo.validator;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import pl.cantabo.database.profile.ProfileDAO;
import pl.cantabo.database.profile.ProfileRepository;

import javax.validation.ValidationException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Component
@RequiredArgsConstructor
public class ProfileValidator {

    private final ProfileRepository profileRepository;

    public boolean checkIsSameProfile(UUID id, ProfileDAO profile) {
        Optional<ProfileDAO> foundProfile = profileRepository.findByName(profile.getName());
        return foundProfile.isPresent() && foundProfile.get().getId().equals(id);
    }

    public void validateProfile(ProfileDAO profileDAO, boolean isSameProfile) {
        List<String> validationErrors = new ArrayList<>();

        if (profileDAO.getName() == null || profileDAO.getName().isEmpty()) {
            validationErrors.add("Nazwa profilu nie może być pusta\n");
        }

        if (!isSameProfile) {
            if (profileRepository.findByName(profileDAO.getName()).isPresent()) {
                validationErrors.add("Profil o podanej nazwie już istnieje\n");
            }
        }

        if (!validationErrors.isEmpty()) {
            String errorMessage = String.join("", validationErrors);
            throw new ValidationException(errorMessage);
        }
    }
}
