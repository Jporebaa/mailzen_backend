package pl.cantabo.database.profile;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;
import pl.cantabo.database.profile.factory.ProfileDAOFactory;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
class ProfileRepositoryTest {

    @Autowired
    private ProfileRepository profileRepository;

    @BeforeEach
    public void setUp() {
        profileRepository.deleteAll();
    }

    @Test
    public void saveProfileTest() {
        // given
        ProfileDAO profileDAO = ProfileDAOFactory.defaultBuilder().build();

        // when
        ProfileDAO savedProfileDAO = profileRepository.saveAndFlush(profileDAO);

        // then
        assertNotNull(savedProfileDAO.getId());
        assertEquals(profileDAO, savedProfileDAO);
    }

    @Test
    public void updateProfileTest() {
        // given
        ProfileDAO profileDAO = ProfileDAOFactory.defaultBuilder().build();
        profileDAO.setName("oldName");

        // when
        profileRepository.saveAndFlush(profileDAO);
        profileDAO.setName("newName");
        ProfileDAO savedProfileDAO = profileRepository.saveAndFlush(profileDAO);

        // then
        assertNotNull(savedProfileDAO);
        assertEquals(profileDAO.getId(), savedProfileDAO.getId());
        assertEquals("newName", savedProfileDAO.getName());
    }

    @Test
    public void deleteProfileTest() {
        // given
        ProfileDAO profileDAO = ProfileDAOFactory.defaultBuilder().build();
        profileRepository.saveAndFlush(profileDAO);

        // when
        profileRepository.delete(profileDAO);
        profileRepository.flush();

        // then
        assertFalse(profileRepository.findById(profileDAO.getId()).isPresent());
    }

    @Test
    public void findAllProfileTest() {
        // given
        ProfileDAO profileDAO1 = ProfileDAOFactory.defaultBuilder().name("profile1").build();
        ProfileDAO profileDAO2 = ProfileDAOFactory.defaultBuilder().name("profile2").build();
        profileRepository.saveAndFlush(profileDAO1);
        profileRepository.saveAndFlush(profileDAO2);

        // when
        List<ProfileDAO> profileDAOList = profileRepository.findAll();

        // then
        assertEquals(2, profileDAOList.size());
    }

    @Test
    public void findProfileByNameTest() {
        // given
        ProfileDAO profileDAO = ProfileDAOFactory.defaultBuilder().name("Profile1").build();
        ProfileDAO profileDAO2 = ProfileDAOFactory.defaultBuilder().name("Profile2").build();
        ProfileDAO profileDAO3 = ProfileDAOFactory.defaultBuilder().name("Profile3").build();

        profileRepository.saveAndFlush(profileDAO);
        profileRepository.saveAndFlush(profileDAO2);
        profileRepository.saveAndFlush(profileDAO3);

        // when
        List<ProfileDAO> profileProfile = profileRepository.findProfileByName("Profile");
        List<ProfileDAO> profileProfile2 = profileRepository.findProfileByName("Profile2");

        // then
        assertEquals(3, profileProfile.size());
        assertEquals(1, profileProfile2.size());
    }
}