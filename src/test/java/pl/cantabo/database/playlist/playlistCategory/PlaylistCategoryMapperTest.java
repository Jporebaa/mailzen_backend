package pl.cantabo.database.playlist.playlistCategory;

import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import pl.cantabo.database.configuration.MapperConfiguration;
import pl.cantabo.database.playlist.playlistCategory.factory.PlaylistCategoryDAOFactory;
import pl.cantabo.database.playlist.playlistCategory.factory.PlaylistCategoryDTOFactory;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = MapperConfiguration.class)
public class PlaylistCategoryMapperTest {

    @Autowired
    private PlaylistCategoryMapper playlistCategoryMapper;

    @Test
    void playlistCategoryDAO2PlaylistCategoryInfoDTO() {
        // given
        PlaylistCategoryDAO playlistCategoryDAO = PlaylistCategoryDAOFactory.defaultBuilder().build();

        // when
        PlaylistCategoryInfoDTO playlistCategoryInfoDTO = playlistCategoryMapper.playlistCategoryDAO2PlaylistCategoryInfoDTO(playlistCategoryDAO);

        // then
        assertNotNull(playlistCategoryInfoDTO);
        SoftAssertions softly = new SoftAssertions();
        softly.assertThat(playlistCategoryDAO.getName()).isEqualTo(playlistCategoryInfoDTO.getName());
        softly.assertAll();
    }

    @Test
    void playlistCategoryCreateDTO2PlaylistCategoryDAO() {
        // given
        PlaylistCategoryCreateDTO playlistCategoryCreateDTO = PlaylistCategoryDTOFactory.defaultPlaylistCategoryCreateDTO();

        // when
        PlaylistCategoryDAO playlistCategoryDAO = playlistCategoryMapper.playlistCategoryCreateDTO2PlaylistCategoryDAO(playlistCategoryCreateDTO);

        // then
        assertNotNull(playlistCategoryDAO);
        SoftAssertions softly = new SoftAssertions();
        softly.assertThat(playlistCategoryCreateDTO.getName()).isEqualTo(playlistCategoryDAO.getName());
        softly.assertAll();
    }

    @Test
    void playlistCategoryUpdateDTO2PlaylistCategoryDAO() {
        // given
        PlaylistCategoryUpdateDTO playlistCategoryUpdateDTO = PlaylistCategoryDTOFactory.defaultPlaylistCategoryDTO();

        // when
        PlaylistCategoryDAO playlistCategoryDAO = playlistCategoryMapper.playlistCategoryUpdateDTO2PlaylistCategoryDAO(playlistCategoryUpdateDTO);

        // then
        assertNotNull(playlistCategoryDAO);
        SoftAssertions softly = new SoftAssertions();
        softly.assertThat(playlistCategoryUpdateDTO.getName()).isEqualTo(playlistCategoryDAO.getName());
        softly.assertAll();
    }
}
