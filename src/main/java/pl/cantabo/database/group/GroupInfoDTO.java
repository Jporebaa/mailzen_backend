package pl.cantabo.database.group;

import lombok.Data;

import java.util.UUID;

@Data
public class GroupInfoDTO {

    private UUID id;

    private String name;

    private Boolean defaultItem;
}
