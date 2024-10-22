package pl.cantabo.database.playlist.playlistCategory.factory;

import pl.cantabo.database.playlist.playlistCategory.PlaylistCategoryDAO;

public class PlaylistCategoryDAOFactory {

    public static final String NAME = "PlaylistCategory name";
    public static final Boolean DEFAULT_ITEM = true;

    public static PlaylistCategoryDAO.PlaylistCategoryDAOBuilder defaultBuilder() {
        return PlaylistCategoryDAO.builder()
                .name(NAME)
                .defaultItem(DEFAULT_ITEM);
    }
}
