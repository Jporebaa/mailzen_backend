package pl.cantabo.database.group;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Data
public class GroupCreateDTO {
    @NotBlank
    @Size(min = 1, max = 100)
    private String name;

    private Boolean DefaultItem;
}
