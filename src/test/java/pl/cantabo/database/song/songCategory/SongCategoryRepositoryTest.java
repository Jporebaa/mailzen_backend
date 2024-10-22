package pl.cantabo.database.song.songCategory;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;
import pl.cantabo.database.song.songCategory.factory.SongCategoryDAOFactory;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
class SongCategoryRepositoryTest {

    @Autowired
    private SongCategoryRepository songCategoryRepository;

    @BeforeEach
    public void setUp() {
        songCategoryRepository.deleteAll();
    }

    @Test
    public void saveSongCategoryTest() {
        // given
        SongCategoryDAO songCategoryDAO = SongCategoryDAOFactory.defaultBuilder().build();

        // when
        SongCategoryDAO savedSongCategoryDAO = songCategoryRepository.saveAndFlush(songCategoryDAO);

        // then
        assertNotNull(savedSongCategoryDAO.getId());
        assertEquals(songCategoryDAO, savedSongCategoryDAO);
    }

    @Test
    public void updateSongCategoryTest() {
        // given
        SongCategoryDAO songCategoryDAO = SongCategoryDAOFactory.defaultBuilder().build();
        songCategoryDAO.setName("oldName");

        // when
        songCategoryRepository.saveAndFlush(songCategoryDAO);
        songCategoryDAO.setName("newName");
        SongCategoryDAO savedSongCategoryDAO = songCategoryRepository.saveAndFlush(songCategoryDAO);

        // then
        assertNotNull(savedSongCategoryDAO);
        assertEquals(songCategoryDAO.getId(), savedSongCategoryDAO.getId());
        assertEquals("newName", savedSongCategoryDAO.getName());
    }

    @Test
    public void deleteSongCategory() {
        // given
        SongCategoryDAO songCategoryDAO = SongCategoryDAOFactory.defaultBuilder().build();
        songCategoryRepository.saveAndFlush(songCategoryDAO);

        // when
        songCategoryRepository.delete(songCategoryDAO);
        Optional<SongCategoryDAO> deletedSongCategoryDAO = songCategoryRepository.findById(songCategoryDAO.getId());

        // then
        assertFalse(deletedSongCategoryDAO.isPresent());
    }

    @Test
    public void findAllSongCategoryTest() {
        // given
        SongCategoryDAO songCategoryDAO = SongCategoryDAOFactory.defaultBuilder().name("song1").build();
        SongCategoryDAO songCategoryDAO2 = SongCategoryDAOFactory.defaultBuilder().name("song2").build();

        // when
        songCategoryRepository.saveAndFlush(songCategoryDAO);
        songCategoryRepository.saveAndFlush(songCategoryDAO2);
        List<SongCategoryDAO> songCategoryDAOList = songCategoryRepository.findAll();

        // then
        assertEquals(2, songCategoryDAOList.size());
    }

    @Test
    public void findSongCategoryByNameTest() {
        // given
        SongCategoryDAO songCategoryDAO = SongCategoryDAOFactory.defaultBuilder().name("songCategory1").build();
        SongCategoryDAO songCategoryDAO2 = SongCategoryDAOFactory.defaultBuilder().name("songCategory2").build();

        // when
        songCategoryRepository.saveAndFlush(songCategoryDAO);
        songCategoryRepository.saveAndFlush(songCategoryDAO2);
        List<SongCategoryDAO> songCategory = songCategoryRepository.findSongCategoryByName("songCategory");
        List<SongCategoryDAO> songCategory1 = songCategoryRepository.findSongCategoryByName("songCategory1");

        // then
        assertEquals(2, songCategory.size());
        assertEquals(1, songCategory1.size());
    }
}