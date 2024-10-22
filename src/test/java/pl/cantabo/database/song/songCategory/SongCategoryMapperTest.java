package pl.cantabo.database.song.songCategory;

import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import pl.cantabo.database.configuration.MapperConfiguration;
import pl.cantabo.database.song.songCategory.factory.SongCategoryDAOFactory;
import pl.cantabo.database.song.songCategory.factory.SongCategoryDTOFactory;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = MapperConfiguration.class)
class SongCategoryMapperTest {

    @Autowired
    private SongCategoryMapper songCategoryMapper;

    @Test
    void songCategoryDAO2SongCategoryInfoDTO() {
        // given
        SongCategoryDAO songCategoryDAO = SongCategoryDAOFactory.defaultBuilder().build();

        // when
        SongCategoryInfoDTO songCategoryInfoDTO = songCategoryMapper.songCategoryDAO2SongCategoryInfoDTO(songCategoryDAO);

        // then
        assertNotNull(songCategoryInfoDTO);
        SoftAssertions softly = new SoftAssertions();
        softly.assertThat(songCategoryDAO.getName()).isEqualTo(songCategoryInfoDTO.getName());
        softly.assertAll();
    }

    @Test
    void songCategoryCreateDTO2SongCategoryDAO() {
        // given
        SongCategoryCreateDTO songCategoryCreateDTO = SongCategoryDTOFactory.defaultSongCategoryCreateDTO();

        // when
        SongCategoryDAO songCategoryDAO = songCategoryMapper.songCategoryCreateDTO2SongCategoryDAO(songCategoryCreateDTO);

        // then
        assertNotNull(songCategoryDAO);
        SoftAssertions softly = new SoftAssertions();
        softly.assertThat(songCategoryCreateDTO.getName()).isEqualTo(songCategoryDAO.getName());
        softly.assertAll();
    }

    @Test
    void songCategoryUpdateDTO2SongCategoryDAO() {
        // given
        SongCategoryUpdateDTO songCategoryUpdateDTO = SongCategoryDTOFactory.defaultSongCategoryUpdateDTO();

        // when
        SongCategoryDAO songCategoryDAO = songCategoryMapper.songCategoryUpdateDTO2SongCategoryDAO(songCategoryUpdateDTO);

        // then
        assertNotNull(songCategoryDAO);
        SoftAssertions softly = new SoftAssertions();
        softly.assertThat(songCategoryUpdateDTO.getName()).isEqualTo(songCategoryDAO.getName());
        softly.assertAll();
    }
}