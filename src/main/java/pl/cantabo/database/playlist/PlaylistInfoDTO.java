package pl.cantabo.database.playlist;

import lombok.Data;
import pl.cantabo.database.playlist.playlistCategory.PlaylistCategoryDAO;

import java.util.List;
import java.util.UUID;

@Data
public class PlaylistInfoDTO {

    private UUID id;

    private String name;

    private List<PlaylistCategoryDAO> playlistCategories;
}

