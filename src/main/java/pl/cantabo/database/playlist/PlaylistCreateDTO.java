package pl.cantabo.database.playlist;

import lombok.Data;
import pl.cantabo.database.playlist.playlistCategory.PlaylistCategoryDAO;
import pl.cantabo.database.song.SongDAO;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.List;
import java.util.Set;

@Data
public class PlaylistCreateDTO {
    @NotBlank
    @Size(min = 1, max = 100)
    private String name;

    private List<PlaylistCategoryDAO> playlistCategories;

    private Set<SongDAO> songs;
}
