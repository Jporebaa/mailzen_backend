package pl.cantabo.database.user;

import lombok.Data;
import pl.cantabo.database.group.GroupDAO;

import java.util.UUID;

@Data
public class UserInfoDTO {

    private UUID id;

    private String name;

    private UserType userType;

    private String email;

    private Boolean active;

    private GroupDAO group;
}
