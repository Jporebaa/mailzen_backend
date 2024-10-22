package pl.cantabo.database.group.factory;

import pl.cantabo.database.group.GroupDAO;

import java.util.List;

public class GroupDAOFactory {

    public static final Boolean DEFAULT_ITEM = true;
    public static final String NAME = "Group Name";

    public static GroupDAO.GroupDAOBuilder defaultBuilder() {
        return GroupDAO.builder()
                .defaultItem(DEFAULT_ITEM)
                .name(NAME);
    }

    public static List<GroupDAO> defaultList() {
        return List.of(
                defaultBuilder().name("Test Group 1").build(),
                defaultBuilder().name("Test Group 2").build()
        );
    }
}
