package pl.cantabo.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import pl.cantabo.database.playlist.playlistCategory.PlaylistCategoryDAO;
import pl.cantabo.database.playlist.playlistCategory.PlaylistCategoryRepository;
import pl.cantabo.database.playlist.playlistCategory.factory.PlaylistCategoryDAOFactory;
import pl.cantabo.validator.PlaylistCategoryValidator;

import java.util.List;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;

class PlaylistCategoryServiceTest {

    private PlaylistCategoryService playlistCategoryService;
    private PlaylistCategoryRepository playlistCategoryRepository;

    @BeforeEach
    public void init() {
        playlistCategoryRepository = Mockito.mock(PlaylistCategoryRepository.class);
        playlistCategoryService = new PlaylistCategoryService(playlistCategoryRepository, new PlaylistCategoryValidator(playlistCategoryRepository));
    }

    @Test
    void create() {
        // given
        PlaylistCategoryDAO playlistCategory = PlaylistCategoryDAOFactory.defaultBuilder().build();

        // when
        playlistCategoryService.create(playlistCategory);

        // then
        verify(playlistCategoryRepository, times(1)).save(playlistCategory);
        assertNotNull(playlistCategory);
    }

    @Test
    void delete() {
        // given
        UUID id = UUID.randomUUID();

        // when
        playlistCategoryService.delete(id);

        // then
        verify(playlistCategoryRepository, times(1)).deleteById(id);
    }

    @Test
    void getAll() {
        // given
        List<PlaylistCategoryDAO> playlistCategoryList = List.of(
                PlaylistCategoryDAOFactory.defaultBuilder().build(),
                PlaylistCategoryDAOFactory.defaultBuilder().build(),
                PlaylistCategoryDAOFactory.defaultBuilder().build()
        );

        when(playlistCategoryRepository.findAll()).thenReturn(playlistCategoryList);

        // when
        List<PlaylistCategoryDAO> result = playlistCategoryService.getAll();

        // then
        verify(playlistCategoryRepository, times(1)).findAll();
        assertEquals(playlistCategoryList, result);
    }
}
