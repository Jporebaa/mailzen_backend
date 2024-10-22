package pl.cantabo.database.playlist.factory;

import pl.cantabo.database.playlist.PlaylistDAO;

public class PlaylistDAOFactory {

    public static final String NAME = "Playlist name";
    public static final Boolean DEFAULT_ITEM = true;

    public static PlaylistDAO.PlaylistDAOBuilder defaultBuilder() {
        return PlaylistDAO.builder()
                .name(NAME)
                .defaultItem(DEFAULT_ITEM);
    }
}
