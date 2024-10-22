package pl.cantabo.database.playlist.playlistCategory;

import lombok.Data;

import java.util.UUID;

@Data
public class PlaylistCategoryInfoDTO {

    private UUID id;

    private String name;
}
