package pl.cantabo.database.playlist.playlistCategory.factory;

import pl.cantabo.database.playlist.playlistCategory.PlaylistCategoryCreateDTO;
import pl.cantabo.database.playlist.playlistCategory.PlaylistCategoryUpdateDTO;

public class PlaylistCategoryDTOFactory {

    public static PlaylistCategoryCreateDTO defaultPlaylistCategoryCreateDTO() {
        PlaylistCategoryCreateDTO playlistCategoryCreateDTO = new PlaylistCategoryCreateDTO();
        playlistCategoryCreateDTO.setName(PlaylistCategoryDAOFactory.NAME);
        return playlistCategoryCreateDTO;
    }

    public static PlaylistCategoryUpdateDTO defaultPlaylistCategoryDTO() {
        PlaylistCategoryUpdateDTO playlistCategoryUpdateDTO = new PlaylistCategoryUpdateDTO();
        playlistCategoryUpdateDTO.setName(PlaylistCategoryDAOFactory.NAME);
        return playlistCategoryUpdateDTO;
    }
}
