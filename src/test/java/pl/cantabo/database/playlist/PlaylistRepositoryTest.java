package pl.cantabo.database.playlist;

import jakarta.transaction.Transactional;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import pl.cantabo.database.playlist.factory.PlaylistDAOFactory;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
public class PlaylistRepositoryTest {

    @Autowired
    private PlaylistRepository playlistRepository;

    @BeforeEach
    public void setUp() {
        playlistRepository.deleteAll();
    }

    @Test
    public void savePlaylistTest() {
        //given
        PlaylistDAO playlistDAO = PlaylistDAOFactory.defaultBuilder().build();

        // when
        PlaylistDAO savedPlaylistDAO = playlistRepository.saveAndFlush(playlistDAO);

        // then
        assertNotNull(savedPlaylistDAO.getId());
        assertEquals(playlistDAO, savedPlaylistDAO);
    }

    @Test
    public void deletePlaylistTest() {
        //given
        PlaylistDAO playlistDAO = PlaylistDAOFactory.defaultBuilder().build();
        playlistRepository.saveAndFlush(playlistDAO);

        // when
        playlistRepository.delete(playlistDAO);
        PlaylistDAO deletedPlaylistDAO = playlistRepository.findById(playlistDAO.getId()).orElse(null);

        // then
        assertNull(deletedPlaylistDAO);
    }

    @Test
    public void findAllPlaylistTest() {
        // given
        PlaylistDAO playlistDAO1 = PlaylistDAOFactory.defaultBuilder().name("playlist1").build();
        PlaylistDAO playlistDAO2 = PlaylistDAOFactory.defaultBuilder().name("playlist2").build();
        playlistRepository.saveAndFlush(playlistDAO1);
        playlistRepository.saveAndFlush(playlistDAO2);

        // when
        List<PlaylistDAO> allPlaylist = playlistRepository.findAll();

        // then
        assertEquals(2, allPlaylist.size());
    }
}
