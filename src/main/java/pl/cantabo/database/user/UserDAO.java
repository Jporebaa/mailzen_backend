package pl.cantabo.database.user;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import pl.cantabo.auditor.Auditable;
import pl.cantabo.database.group.GroupDAO;
import pl.cantabo.database.settings.SettingsDAO;
import pl.cantabo.validator.email.Email;
import pl.cantabo.validator.password.Password;

import javax.validation.constraints.NotEmpty;
import java.time.ZonedDateTime;
import java.util.UUID;

@Entity
@Builder
@EqualsAndHashCode(callSuper = false)
@Data
@Table(name = "users")
public class UserDAO extends Auditable<UUID> {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column(columnDefinition = "text", nullable = false, unique = true)
    @NotEmpty
    private String name;

    @NotEmpty
    @Enumerated(EnumType.STRING)
    private UserType userType;

    @Column(columnDefinition = "text", nullable = false, unique = true)
    @NotEmpty
    @Email
    private String email;

    @Column(columnDefinition = "text", nullable = false)
    @NotEmpty
    @Password
    private String password;

    private Boolean active;

    @Column(columnDefinition = "text")
    private String token;

    private ZonedDateTime tokenExpiration;

    @ManyToOne
    @JoinColumn(name = "groupId")
    private GroupDAO group;

    @OneToOne(mappedBy = "user")
    private SettingsDAO settings;

    private boolean defaultItem;

    public UserDAO() {
    }

    public UserDAO(UUID id, String name, UserType userType, String email, String password, Boolean active, String token, ZonedDateTime tokenExpiration, GroupDAO group, SettingsDAO settings, boolean defaultItem) {
        this.id = id;
        this.name = name;
        this.userType = userType;
        this.email = email;
        this.password = password;
        this.active = active;
        this.token = token;
        this.tokenExpiration = tokenExpiration;
        this.group = group;
        this.settings = settings;
        this.defaultItem = defaultItem;
    }
}
