package pl.cantabo.database.song;

import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import pl.cantabo.database.configuration.MapperConfiguration;
import pl.cantabo.database.song.factory.SongDAOFactory;
import pl.cantabo.database.song.factory.SongDTOFactory;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = MapperConfiguration.class)
class SongMapperTest {

    @Autowired
    private SongMapper songMapper;

    @Test
    void songDAO2SongInfoDTO() {
        // given
        SongDAO songDAO = SongDAOFactory.defaultBuilder().build();

        // when
        SongInfoDTO songInfoDTO = songMapper.songDAO2SongInfoDTO(songDAO);

        // then
        assertNotNull(songInfoDTO);
        SoftAssertions softly = new SoftAssertions();
        softly.assertThat(songDAO.getName()).isEqualTo(songInfoDTO.getName());
        softly.assertThat(songDAO.getMusicAuthor()).isEqualTo(songInfoDTO.getMusicAuthor());
        softly.assertThat(songDAO.getWordsAuthor()).isEqualTo(songInfoDTO.getWordsAuthor());
        softly.assertAll();
    }

    @Test
    void songCreateDTO2SongDAO() {
        // given
        SongCreateDTO songCreateDTO = SongDTOFactory.defaultSongCreateDTO();

        // when
        SongDAO songDAO = songMapper.songCreateDTO2SongDAO(songCreateDTO);

        // then
        assertNotNull(songDAO);
        SoftAssertions softly = new SoftAssertions();
        softly.assertThat(songCreateDTO.getName()).isEqualTo(songDAO.getName());
        softly.assertThat(songCreateDTO.getMusicAuthor()).isEqualTo(songDAO.getMusicAuthor());
        softly.assertThat(songCreateDTO.getWordsAuthor()).isEqualTo(songDAO.getWordsAuthor());
        softly.assertAll();
    }

    @Test
    void songUpdateDTO2SongDAO() {
        // given
        SongUpdateDTO songUpdateDTO = SongDTOFactory.defaultSongUpdateDTO();

        // when
        SongDAO songDAO = songMapper.songUpdateDTO2SongDAO(songUpdateDTO);

        // then
        assertNotNull(songDAO);
        SoftAssertions softly = new SoftAssertions();
        softly.assertThat(songUpdateDTO.getName()).isEqualTo(songDAO.getName());
        softly.assertThat(songUpdateDTO.getMusicAuthor()).isEqualTo(songDAO.getMusicAuthor());
        softly.assertThat(songUpdateDTO.getWordsAuthor()).isEqualTo(songDAO.getWordsAuthor());
        softly.assertAll();
    }
}