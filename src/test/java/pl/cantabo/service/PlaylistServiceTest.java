package pl.cantabo.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import pl.cantabo.database.playlist.PlaylistDAO;
import pl.cantabo.database.playlist.PlaylistRepository;
import pl.cantabo.database.playlist.factory.PlaylistDAOFactory;
import pl.cantabo.validator.PlaylistValidator;

import java.util.List;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;

class PlaylistServiceTest {

    private PlaylistService playlistService;
    private PlaylistRepository playlistRepository;

    @BeforeEach
    public void init() {
        playlistRepository = Mockito.mock(PlaylistRepository.class);
        playlistService = new PlaylistService(playlistRepository, null, null, new PlaylistValidator(playlistRepository));
    }

    @Test
    void create() {
        // given
        PlaylistDAO playlist = PlaylistDAOFactory.defaultBuilder().build();

        // when
        playlistService.create(playlist);

        // then
        verify(playlistRepository, times(1)).save(playlist);
        assertNotNull(playlist);
    }

    @Test
    void delete() {
        // given
        UUID id = UUID.randomUUID();

        // when
        playlistService.delete(id);

        // then
        verify(playlistRepository, times(1)).deleteById(id);
    }

    @Test
    void getAll() {
        // given
        List<PlaylistDAO> playlistList = List.of(
                PlaylistDAOFactory.defaultBuilder().build(),
                PlaylistDAOFactory.defaultBuilder().build(),
                PlaylistDAOFactory.defaultBuilder().build()
        );
        when(playlistRepository.findAll()).thenReturn(playlistList);

        // when
        List<PlaylistDAO> playlistDAOList = playlistService.getAll();

        // then
        verify(playlistRepository, times(1)).findAll();
        assertEquals(3, playlistDAOList.size());
    }
}
