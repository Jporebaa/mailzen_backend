package pl.cantabo.database.playlist;

import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import pl.cantabo.database.configuration.MapperConfiguration;
import pl.cantabo.database.playlist.factory.PlaylistDAOFactory;
import pl.cantabo.database.playlist.factory.PlaylistDTOFactory;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = MapperConfiguration.class)
public class PlaylistMapperTest {

    @Autowired
    private PlaylistMapper playlistMapper;

    @Test
    void playlistDAO2PlaylistInfoDTO() {
        // given
        PlaylistDAO playlistDAO = PlaylistDAOFactory.defaultBuilder().build();

        // when
        PlaylistInfoDTO playlistInfoDTO = playlistMapper.playlistDAO2PlaylistInfoDTO(playlistDAO);

        // then
        assertNotNull(playlistInfoDTO);
        SoftAssertions softly = new SoftAssertions();
        softly.assertThat(playlistDAO.getName()).isEqualTo(playlistInfoDTO.getName());
        softly.assertAll();
    }

    @Test
    void playlistCreateDTO2PlaylistDAO() {
        // given
        PlaylistCreateDTO playlistCreateDTO = PlaylistDTOFactory.defaultPlaylistCreateDTO();

        // when
        PlaylistDAO playlistDAO = playlistMapper.playlistCreateDTO2PlaylistDAO(playlistCreateDTO);

        // then
        assertNotNull(playlistDAO);
        SoftAssertions softly = new SoftAssertions();
        softly.assertThat(playlistCreateDTO.getName()).isEqualTo(playlistDAO.getName());
        softly.assertAll();
    }

    @Test
    void PlaylistUpdateDTO2PlaylistDAO() {
        // given
        PlaylistUpdateDTO playlistUpdateDTO = PlaylistDTOFactory.defaultPlaylistUpdateDTO();

        // when
        PlaylistDAO playlistDAO = playlistMapper.playlistUpdateDTO2PlaylistDAO(playlistUpdateDTO);

        // then
        assertNotNull(playlistDAO);
        SoftAssertions softly = new SoftAssertions();
        softly.assertThat(playlistUpdateDTO.getName()).isEqualTo(playlistDAO.getName());
    }
}
