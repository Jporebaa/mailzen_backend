package pl.cantabo.database.settings;

import lombok.Data;

import java.util.UUID;

@Data
public class SettingsInfoDTO {

    private UUID id;

    private float fontSize;

    private boolean darkTheme;
}
