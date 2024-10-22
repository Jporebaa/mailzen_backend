package pl.cantabo.database.settings;

import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import pl.cantabo.database.configuration.MapperConfiguration;
import pl.cantabo.database.settings.factory.SettingsDAOFactory;
import pl.cantabo.database.settings.factory.SettingsDTOFactory;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = MapperConfiguration.class)
class SettingsMapperTest {

    @Autowired
    private SettingsMapper settingsMapper;

    @Test
    void settingsDAO2SettingsDTO() {
        // given
        SettingsDAO settingsDAO = SettingsDAOFactory.defaultBuilder().build();

        // when
        SettingsInfoDTO settingsInfoDTO = settingsMapper.settingsDA2SettingsDTO(settingsDAO);

        // then
        assertNotNull(settingsInfoDTO);
        SoftAssertions softly = new SoftAssertions();
        softly.assertThat(settingsDAO.isDarkTheme()).isEqualTo(settingsInfoDTO.isDarkTheme());
        softly.assertThat(settingsDAO.getFontSize()).isEqualTo(settingsInfoDTO.getFontSize());
        softly.assertAll();
    }

    @Test
    void settingsCreateDAO2SettingsDTO() {
        // given
        SettingsCreateDTO settingsCreateDTO = SettingsDTOFactory.defaultSettingsCreateDTO();

        // when
        SettingsDAO settingsDAO = settingsMapper.settingsCreateDAO2SettingsDTO(settingsCreateDTO);

        // then
        assertNotNull(settingsDAO);
        SoftAssertions softly = new SoftAssertions();
        softly.assertThat(settingsCreateDTO.isDarkTheme()).isEqualTo(settingsDAO.isDarkTheme());
        softly.assertThat(settingsCreateDTO.getFontSize()).isEqualTo(settingsDAO.getFontSize());
        softly.assertAll();
    }


    @Test
    void settingsUpdateDAO2SettingsDTO() {
        // given
        SettingsUpdateDTO settingsUpdateDTO = SettingsDTOFactory.defaultSettingsDTO();

        // when
        SettingsDAO settingsDAO = settingsMapper.settingsUpdateDAO2SettingsDTO(settingsUpdateDTO);

        // then
        assertNotNull(settingsDAO);
        SoftAssertions softly = new SoftAssertions();
        softly.assertThat(settingsUpdateDTO.isDarkTheme()).isEqualTo(settingsDAO.isDarkTheme());
        softly.assertThat(settingsDAO.getFontSize()).isEqualTo(settingsDAO.getFontSize());
        softly.assertAll();
    }
}