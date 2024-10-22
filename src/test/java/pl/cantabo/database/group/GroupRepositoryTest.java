package pl.cantabo.database.group;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;
import pl.cantabo.database.group.factory.GroupDAOFactory;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
class GroupRepositoryTest {

    @Autowired
    private GroupRepository groupRepository;

    @BeforeEach
    public void setUp() {
        groupRepository.deleteAll();
    }

    @Test
    public void saveGroupTest() {
        // given
        GroupDAO groupDAO = GroupDAOFactory.defaultBuilder().build();

        // when
        GroupDAO savedGroupDAO = groupRepository.saveAndFlush(groupDAO);

        // then
        assertNotNull(savedGroupDAO.getId());
        assertEquals(groupDAO, savedGroupDAO);
    }

    @Test
    public void updateGroupTest() {
        // given
        GroupDAO groupDAO = GroupDAOFactory.defaultBuilder().build();
        groupDAO.setName("oldName");

        // when
        groupRepository.saveAndFlush(groupDAO);
        groupDAO.setName("newName");
        GroupDAO savedGroupDAO = groupRepository.saveAndFlush(groupDAO);

        // then
        assertNotNull(savedGroupDAO);
        assertEquals(groupDAO.getId(), savedGroupDAO.getId());
        assertEquals("newName", savedGroupDAO.getName());
    }

    @Test
    public void deleteGroupTest() {
        // given
        GroupDAO groupDAO = GroupDAOFactory.defaultBuilder().build();

        // when
        groupRepository.saveAndFlush(groupDAO);
        groupRepository.delete(groupDAO);
        Optional<GroupDAO> optionalGroupDAO = groupRepository.findById(groupDAO.getId());

        // then
        assertFalse(optionalGroupDAO.isPresent());
    }

    @Test
    public void findAllGroupTest() {
        // given
        GroupDAO groupDAO1 = GroupDAOFactory.defaultBuilder().name("group1").build();
        GroupDAO groupDAO2 = GroupDAOFactory.defaultBuilder().name("group2").build();

        // when
        groupRepository.saveAndFlush(groupDAO1);
        groupRepository.saveAndFlush(groupDAO2);
        List<GroupDAO> groupDAOList = groupRepository.findAll();

        // then
        assertEquals(2, groupDAOList.size());
    }
}