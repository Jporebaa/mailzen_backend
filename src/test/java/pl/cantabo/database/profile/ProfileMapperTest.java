package pl.cantabo.database.profile;

import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import pl.cantabo.database.configuration.MapperConfiguration;
import pl.cantabo.database.profile.factory.ProfileDAOFactory;
import pl.cantabo.database.profile.factory.ProfileDTOFactory;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = MapperConfiguration.class)
class ProfileMapperTest {

    @Autowired
    private ProfileMapper profileMapper;

    @Test
    void profileDAO2ProfileInfoDTO() {
        // given
        ProfileDAO profileDAO = ProfileDAOFactory.defaultBuilder().build();

        // when
        ProfileInfoDTO profileInfoDTO = profileMapper.profileDAO2ProfileInfoDTO(profileDAO);

        // then
        assertNotNull(profileInfoDTO);
        SoftAssertions softly = new SoftAssertions();
        softly.assertThat(profileDAO.getName()).isEqualTo(profileInfoDTO.getName());
        softly.assertThat(profileDAO.isActive()).isEqualTo(profileInfoDTO.isActive());
        softly.assertThat(profileDAO.isSortByUsed()).isEqualTo(profileInfoDTO.isSortByUsed());
        softly.assertThat(profileDAO.getBgColor()).isEqualTo(profileInfoDTO.getBgColor());
        softly.assertThat(profileDAO.getTxColor()).isEqualTo(profileInfoDTO.getTxColor());
        softly.assertThat(profileDAO.getStopColor()).isEqualTo(profileInfoDTO.getStopColor());
        softly.assertThat(profileDAO.getFontStyle()).isEqualTo(profileInfoDTO.getFontStyle());
        softly.assertThat(profileDAO.getMargin()).isEqualTo(profileInfoDTO.getMargin());
        softly.assertThat(profileDAO.getMaxFont()).isEqualTo(profileInfoDTO.getMaxFont());
        softly.assertThat(profileDAO.getMaxMin()).isEqualTo(profileInfoDTO.getMaxMin());
        softly.assertThat(profileDAO.getAlign()).isEqualTo(profileInfoDTO.getAlign());
        softly.assertThat(profileDAO.getAlgorithmRange()).isEqualTo(profileInfoDTO.getAlgorithmRange());
        softly.assertThat(profileDAO.isShowTitle()).isEqualTo(profileInfoDTO.isShowTitle());
        softly.assertThat(profileDAO.isAllBig()).isEqualTo(profileInfoDTO.isAllBig());
        softly.assertThat(profileDAO.isShowEmptySlide()).isEqualTo(profileInfoDTO.isShowEmptySlide());
        softly.assertThat(profileDAO.isInvertColors()).isEqualTo(profileInfoDTO.isInvertColors());
        softly.assertThat(profileDAO.isExpandedList()).isEqualTo(profileInfoDTO.isExpandedList());
        softly.assertAll();
    }

    @Test
    void profileCreateDTO2ProfileDAO() {
        // given
        ProfileCreateDTO profileCreateDTO = ProfileDTOFactory.defaultProfileCreateDTO();

        // when
        ProfileDAO profileDAO = profileMapper.profileCreateDTO2ProfileDAO(profileCreateDTO);

        // then
        assertNotNull(profileDAO);
        SoftAssertions softly = new SoftAssertions();
        softly.assertThat(profileCreateDTO.getName()).isEqualTo(profileDAO.getName());
        softly.assertThat(profileCreateDTO.isActive()).isEqualTo(profileDAO.isActive());
        softly.assertThat(profileCreateDTO.isSortByUsed()).isEqualTo(profileDAO.isSortByUsed());
        softly.assertThat(profileCreateDTO.getBgColor()).isEqualTo(profileDAO.getBgColor());
        softly.assertThat(profileCreateDTO.getTxColor()).isEqualTo(profileDAO.getTxColor());
        softly.assertThat(profileCreateDTO.getStopColor()).isEqualTo(profileDAO.getStopColor());
        softly.assertThat(profileCreateDTO.getFontStyle()).isEqualTo(profileDAO.getFontStyle());
        softly.assertThat(profileCreateDTO.getMargin()).isEqualTo(profileDAO.getMargin());
        softly.assertThat(profileCreateDTO.getMaxFont()).isEqualTo(profileDAO.getMaxFont());
        softly.assertThat(profileCreateDTO.getMaxMin()).isEqualTo(profileDAO.getMaxMin());
        softly.assertThat(profileCreateDTO.getAlign()).isEqualTo(profileDAO.getAlign());
        softly.assertThat(profileCreateDTO.getAlgorithmRange()).isEqualTo(profileDAO.getAlgorithmRange());
        softly.assertThat(profileCreateDTO.isShowTitle()).isEqualTo(profileDAO.isShowTitle());
        softly.assertThat(profileCreateDTO.isAllBig()).isEqualTo(profileDAO.isAllBig());
        softly.assertThat(profileCreateDTO.isShowEmptySlide()).isEqualTo(profileDAO.isShowEmptySlide());
        softly.assertThat(profileCreateDTO.isInvertColors()).isEqualTo(profileDAO.isInvertColors());
        softly.assertThat(profileCreateDTO.isExpandedList()).isEqualTo(profileDAO.isExpandedList());
        softly.assertAll();
    }

    @Test
    void profileUpdateDTO2ProfileDAO() {
        // given
        ProfileUpdateDTO profileUpdateDTO = ProfileDTOFactory.defaultProfileUpdateDTO();

        // when
        ProfileDAO profileDAO = profileMapper.profileUpdateDTO2ProfileDAO(profileUpdateDTO);

        // then
        assertNotNull(profileDAO);
        SoftAssertions softly = new SoftAssertions();
        softly.assertThat(profileUpdateDTO.getName()).isEqualTo(profileDAO.getName());
        softly.assertThat(profileUpdateDTO.isActive()).isEqualTo(profileDAO.isActive());
        softly.assertThat(profileUpdateDTO.isSortByUsed()).isEqualTo(profileDAO.isSortByUsed());
        softly.assertThat(profileUpdateDTO.getBgColor()).isEqualTo(profileDAO.getBgColor());
        softly.assertThat(profileUpdateDTO.getTxColor()).isEqualTo(profileDAO.getTxColor());
        softly.assertThat(profileUpdateDTO.getStopColor()).isEqualTo(profileDAO.getStopColor());
        softly.assertThat(profileUpdateDTO.getFontStyle()).isEqualTo(profileDAO.getFontStyle());
        softly.assertThat(profileUpdateDTO.getMargin()).isEqualTo(profileDAO.getMargin());
        softly.assertThat(profileUpdateDTO.getMaxFont()).isEqualTo(profileDAO.getMaxFont());
        softly.assertThat(profileUpdateDTO.getMaxMin()).isEqualTo(profileDAO.getMaxMin());
        softly.assertThat(profileUpdateDTO.getAlign()).isEqualTo(profileDAO.getAlign());
        softly.assertThat(profileUpdateDTO.getAlgorithmRange()).isEqualTo(profileDAO.getAlgorithmRange());
        softly.assertThat(profileUpdateDTO.isShowTitle()).isEqualTo(profileDAO.isShowTitle());
        softly.assertThat(profileUpdateDTO.isAllBig()).isEqualTo(profileDAO.isAllBig());
        softly.assertThat(profileUpdateDTO.isShowEmptySlide()).isEqualTo(profileDAO.isShowEmptySlide());
        softly.assertThat(profileUpdateDTO.isInvertColors()).isEqualTo(profileDAO.isInvertColors());
        softly.assertThat(profileUpdateDTO.isExpandedList()).isEqualTo(profileDAO.isExpandedList());
        softly.assertAll();
    }
}