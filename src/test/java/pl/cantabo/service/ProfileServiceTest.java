package pl.cantabo.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import pl.cantabo.database.profile.ProfileDAO;
import pl.cantabo.database.profile.ProfileRepository;
import pl.cantabo.database.profile.factory.ProfileDAOFactory;
import pl.cantabo.validator.ProfileValidator;

import java.util.List;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class ProfileServiceTest {

    private ProfileService profileService;

    private ProfileRepository profileRepository;

    @BeforeEach
    public void init() {
        profileRepository = Mockito.mock(ProfileRepository.class);
        profileService = new ProfileService(profileRepository, new ProfileValidator(profileRepository));
    }

    @Test
    void create() {
        // given
        ProfileDAO profile = ProfileDAOFactory.defaultBuilder().build();

        // when
        profileService.create(profile);

        // then
        verify(profileRepository, times(1)).save(profile);
    }

    @Test
    void delete() {
        // given
        UUID id = UUID.randomUUID();

        // when
        profileService.delete(id);

        // then
        verify(profileRepository, times(1)).deleteById(id);
    }

    @Test
    void getAll() {
        // given
        List<ProfileDAO> profileList = List.of(
                ProfileDAOFactory.defaultBuilder().build(),
                ProfileDAOFactory.defaultBuilder().build(),
                ProfileDAOFactory.defaultBuilder().build()
        );

        when(profileRepository.findAll()).thenReturn(profileList);

        // when
        List<ProfileDAO> profileDAOList = profileService.getAll();

        // then
        verify(profileRepository, times(1)).findAll();
        assertEquals(3, profileDAOList.size());
    }
}