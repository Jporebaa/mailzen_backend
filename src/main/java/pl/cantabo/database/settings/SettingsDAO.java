package pl.cantabo.database.settings;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import pl.cantabo.auditor.Auditable;
import pl.cantabo.database.user.UserDAO;

import java.util.UUID;

@Entity
@Builder
@EqualsAndHashCode(callSuper = false)
@Data
@Table(name = "settings")
public class SettingsDAO extends Auditable<UUID> {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    private boolean darkTheme;

    private float fontSize;

    @OneToOne
    @JoinColumn(name = "userId")
    private UserDAO user;

    public SettingsDAO() {
    }

    public SettingsDAO(UUID id, boolean darkTheme, float fontSize, UserDAO user) {
        this.id = id;
        this.darkTheme = darkTheme;
        this.fontSize = fontSize;
        this.user = user;
    }
}
