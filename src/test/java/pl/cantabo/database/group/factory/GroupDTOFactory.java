package pl.cantabo.database.group.factory;

import pl.cantabo.database.group.GroupCreateDTO;
import pl.cantabo.database.group.GroupUpdateDTO;

public class GroupDTOFactory {

    public static GroupCreateDTO defaultGroupCreateDTO() {
        GroupCreateDTO groupCreateDTO = new GroupCreateDTO();
        groupCreateDTO.setDefaultItem(GroupDAOFactory.DEFAULT_ITEM);
        groupCreateDTO.setName(GroupDAOFactory.NAME);

        return groupCreateDTO;
    }

    public static GroupUpdateDTO defaultGroupUpdateDTO() {
        GroupUpdateDTO groupUpdateDTO = new GroupUpdateDTO();
        groupUpdateDTO.setDefaultItem(GroupDAOFactory.DEFAULT_ITEM);
        groupUpdateDTO.setName(GroupDAOFactory.NAME);
        return groupUpdateDTO;
    }
}
