package pl.cantabo.validator;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import pl.cantabo.database.group.GroupDAO;
import pl.cantabo.database.group.GroupRepository;

import javax.validation.ValidationException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Component
@RequiredArgsConstructor
public class GroupValidator {

    private final GroupRepository groupRepository;

    public boolean checkIfSameGroup(UUID id, GroupDAO group) {
        Optional<GroupDAO> foundGroup = groupRepository.findByName(group.getName());
        return foundGroup.isPresent() && foundGroup.get().getId().equals(id);
    }

    public void validateGroup(GroupDAO group, boolean isSameGroup) {
        List<String> validationErrors = new ArrayList<>();

        if (group.getName() == null || group.getName().isEmpty()) {
            validationErrors.add("Nazwa grupy nie może być pusta\n");
        }

        if (!isSameGroup) {
            if (groupRepository.findByName(group.getName()).isPresent()) {
                validationErrors.add("Grupa o podanej nazwie już istnieje\n");
            }
        }

        if (!validationErrors.isEmpty()) {
            String errorMessage = String.join("", validationErrors);
            throw new ValidationException(errorMessage);
        }
    }
}
