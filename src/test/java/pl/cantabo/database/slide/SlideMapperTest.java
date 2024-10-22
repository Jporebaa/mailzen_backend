package pl.cantabo.database.slide;

import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import pl.cantabo.database.configuration.MapperConfiguration;
import pl.cantabo.database.slide.factory.SlideDAOFactory;
import pl.cantabo.database.slide.factory.SlideDTOFactory;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = MapperConfiguration.class)
public class SlideMapperTest {

    @Autowired
    private SlideMapper slideMapper;

    @Test
    void slideDAO2SlideInfoDTO() {
        // given
        SlideDAO slideDAO = SlideDAOFactory.defaultBuilder().build();

        // when
        SlideInfoDTO slideInfoDTO = slideMapper.slideDAO2SlideInfoDTO(slideDAO);

        // then
        assertNotNull(slideInfoDTO);
        SoftAssertions softly = new SoftAssertions();
        softly.assertThat(slideDAO.getBody()).isEqualTo(slideInfoDTO.getBody());
        softly.assertThat(slideDAO.getItemOrder()).isEqualTo(slideInfoDTO.getItemOrder());
        softly.assertAll();

    }

    @Test
    void slideCreateDTO2SlideDAO() {
        // given
        SlideCreateDTO slideCreateDTO = SlideDTOFactory.defaultSLideCreateDTO();

        // when
        SlideDAO slideDAO = slideMapper.slideCreateDTO2SlideDAO(slideCreateDTO);

        // then
        assertNotNull(slideDAO);
        SoftAssertions softly = new SoftAssertions();
        softly.assertThat(slideCreateDTO.getBody()).isEqualTo(slideDAO.getBody());
        softly.assertThat(slideCreateDTO.getItemOrder()).isEqualTo(slideDAO.getItemOrder());
        softly.assertAll();
    }

    @Test
    void slideUpdateDTO2SlideDAO() {
        // given
        SlideUpdateDTO slideUpdateDTO = SlideDTOFactory.defaultSlideUpdateDTO();

        // when
        SlideDAO slideDAO = slideMapper.slideUpdateDTO2SlideDAO(slideUpdateDTO);

        // then
        assertNotNull(slideDAO);
        SoftAssertions softly = new SoftAssertions();
        softly.assertThat(slideUpdateDTO.getBody()).isEqualTo(slideDAO.getBody());
        softly.assertThat(slideUpdateDTO.getItemOrder()).isEqualTo(slideDAO.getItemOrder());
        softly.assertAll();
    }
}
