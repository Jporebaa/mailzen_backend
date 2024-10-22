package pl.cantabo.database.song;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;
import pl.cantabo.database.song.factory.SongDAOFactory;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
class SongRepositoryTest {

    @Autowired
    private SongRepository songRepository;

    @BeforeEach
    public void setUp() {
        songRepository.deleteAll();
    }

    @Test
    public void saveSongTest() {
        // given
        SongDAO songDAO = SongDAOFactory.defaultBuilder().build();

        // when
        SongDAO savedSongDAO = songRepository.saveAndFlush(songDAO);

        // then
        assertNotNull(savedSongDAO.getId());
        assertEquals(songDAO, savedSongDAO);
    }

    @Test
    public void updateSongTest() {
        // given
        SongDAO songDAO = SongDAOFactory.defaultBuilder().build();
        songDAO.setName("oldName");

        // when
        songRepository.saveAndFlush(songDAO);
        songDAO.setName("newName");
        SongDAO savedSongDAO = songRepository.saveAndFlush(songDAO);

        // then
        assertNotNull(savedSongDAO);
        assertEquals(songDAO.getId(), savedSongDAO.getId());
        assertEquals("newName", savedSongDAO.getName());
    }

    @Test
    public void deleteSongTest() {
        // given
        SongDAO songDAO = SongDAOFactory.defaultBuilder().build();
        songRepository.saveAndFlush(songDAO);

        // when
        songRepository.delete(songDAO);
        SongDAO deletedSongDAO = songRepository.findById(songDAO.getId()).orElse(null);

        // then
        assertNull(deletedSongDAO);
    }

    @Test
    public void findAllSongsTest() {
        // given
        SongDAO songDAO1 = SongDAOFactory.defaultBuilder().name("song1").build();
        SongDAO songDAO2 = SongDAOFactory.defaultBuilder().name("song2").build();
        songRepository.saveAndFlush(songDAO1);
        songRepository.saveAndFlush(songDAO2);

        // when
        List<SongDAO> allSongs = songRepository.findAll();

        // then
        assertEquals(2, allSongs.size());
    }
}