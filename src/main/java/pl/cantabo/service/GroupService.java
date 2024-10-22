package pl.cantabo.service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;
import pl.cantabo.database.group.GroupDAO;
import pl.cantabo.database.group.GroupRepository;
import pl.cantabo.validator.GroupValidator;

import javax.validation.ValidationException;
import java.util.List;
import java.util.UUID;

@Service
@Log4j2
@RequiredArgsConstructor
public class GroupService {
    private final GroupRepository groupRepository;
    private final GroupValidator groupValidator;

    @Transactional
    public GroupDAO create(GroupDAO group){
        log.debug("Creating group{}", group);
        groupValidator.validateGroup(group, false);
        return log.traceExit(groupRepository.save(group));
    }

    @Transactional
    public GroupDAO update(UUID id, GroupDAO group) {
        log.debug("Updating group {}: {}", id, group);
        boolean isSameGroup = groupValidator.checkIfSameGroup(id, group);
        groupValidator.validateGroup(group, isSameGroup);
        GroupDAO toUpdate = groupRepository.findById(id).orElseThrow(() -> new ValidationException("Grupa o podanym id nie istnieje"));
        toUpdate.setName(group.getName());
        // TODO dodanie pozostałych elementów jakie są zapisywane
        return log.traceExit(groupRepository.save(toUpdate));
    }

    public void delete(UUID id){
        log.debug("Deleting group{}", id);
        groupRepository.deleteById(id);
    }

    public List<GroupDAO> getAll(){
        log.debug("Getting all groups");
        return log.traceExit(groupRepository.findAll());
    }
}
