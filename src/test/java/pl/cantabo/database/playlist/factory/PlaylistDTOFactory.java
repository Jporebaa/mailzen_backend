package pl.cantabo.database.playlist.factory;

import pl.cantabo.database.playlist.PlaylistCreateDTO;
import pl.cantabo.database.playlist.PlaylistUpdateDTO;

public class PlaylistDTOFactory {

    public static PlaylistCreateDTO defaultPlaylistCreateDTO() {
        PlaylistCreateDTO playlistCreateDTO = new PlaylistCreateDTO();
        playlistCreateDTO.setName(PlaylistDAOFactory.NAME);

        return playlistCreateDTO;
    }

    public static PlaylistUpdateDTO defaultPlaylistUpdateDTO() {
        PlaylistUpdateDTO playlistUpdateDTO = new PlaylistUpdateDTO();
        playlistUpdateDTO.setName(PlaylistDAOFactory.NAME);
        return playlistUpdateDTO;
    }
}

