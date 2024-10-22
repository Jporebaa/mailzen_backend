package pl.cantabo.database.settings.factory;

import pl.cantabo.database.settings.SettingsDAO;

public class SettingsDAOFactory {

    public static final Boolean DARK_THEME = false;
    public static final float FONT_SIZE = 12;


    public static SettingsDAO.SettingsDAOBuilder defaultBuilder() {
        return SettingsDAO.builder()
                .darkTheme(DARK_THEME)
                .fontSize(FONT_SIZE);
    }
}