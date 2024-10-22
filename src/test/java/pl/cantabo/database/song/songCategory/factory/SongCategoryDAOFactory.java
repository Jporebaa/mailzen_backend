package pl.cantabo.database.song.songCategory.factory;

import pl.cantabo.database.song.songCategory.SongCategoryDAO;

import java.util.List;

public class SongCategoryDAOFactory {

    public static final String NAME = "Test Song Category";
    public static final boolean DEFAULT_ITEM = true;

    public static SongCategoryDAO.SongCategoryDAOBuilder defaultBuilder() {
        return SongCategoryDAO.builder()
                .name(NAME)
                .defaultItem(DEFAULT_ITEM)
                .songs(null)
                .groups(null);
    }

    public static List<SongCategoryDAO> defaultList() {
        return List.of(
                defaultBuilder().name("Test Song Category 1").build(),
                defaultBuilder().name("Test Song Category 2").build()
        );
    }
}
