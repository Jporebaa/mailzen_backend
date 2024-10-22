package pl.cantabo.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import pl.cantabo.database.group.GroupDAO;
import pl.cantabo.database.group.GroupRepository;
import pl.cantabo.database.group.factory.GroupDAOFactory;
import pl.cantabo.validator.GroupValidator;

import java.util.List;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;

class GroupServiceTest {
    private GroupService groupService;
    private GroupRepository groupRepository;

    @BeforeEach
    public void init() {
        groupRepository = Mockito.mock(GroupRepository.class);
        groupService = new GroupService(groupRepository, new GroupValidator(groupRepository));
    }

    @Test
    void create() {
        // given
        GroupDAO group = GroupDAOFactory.defaultBuilder().build();

        // when
        groupService.create(group);

        // then
        verify(groupRepository, times(1)).save(group);
        assertNotNull(group);
    }

    @Test
    void delete() {
        // given
        UUID id = UUID.randomUUID();

        // when
        groupService.delete(id);

        // then
        verify(groupRepository, times(1)).deleteById(id);
    }

    @Test
    void getAll() {
        // given
        List<GroupDAO> groupList = List.of(
                GroupDAOFactory.defaultBuilder().build(),
                GroupDAOFactory.defaultBuilder().build(),
                GroupDAOFactory.defaultBuilder().build()
        );

        when(groupRepository.findAll()).thenReturn(groupList);

        // when
        List<GroupDAO> groupDAOList = groupService.getAll();

        // then
        verify(groupRepository, times(1)).findAll();
        assertEquals(3, groupDAOList.size());
    }
}
