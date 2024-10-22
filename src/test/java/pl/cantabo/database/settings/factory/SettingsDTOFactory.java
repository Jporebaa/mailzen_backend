package pl.cantabo.database.settings.factory;

import pl.cantabo.database.settings.SettingsCreateDTO;
import pl.cantabo.database.settings.SettingsUpdateDTO;

public class SettingsDTOFactory {

    public static SettingsCreateDTO defaultSettingsCreateDTO() {
        SettingsCreateDTO settingsCreateDTO = new SettingsCreateDTO();
        settingsCreateDTO.setDarkTheme(SettingsDAOFactory.DARK_THEME);
        settingsCreateDTO.setFontSize(SettingsDAOFactory.FONT_SIZE);

        return settingsCreateDTO;
    }

    public static SettingsUpdateDTO defaultSettingsDTO() {
        SettingsUpdateDTO settingsUpdateDTO = new SettingsUpdateDTO();
        settingsUpdateDTO.setDarkTheme(SettingsDAOFactory.DARK_THEME);
        settingsUpdateDTO.setFontSize(SettingsDAOFactory.FONT_SIZE);
        return settingsUpdateDTO;
    }
}