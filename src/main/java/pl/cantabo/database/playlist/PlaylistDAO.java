package pl.cantabo.database.playlist;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import pl.cantabo.auditor.Auditable;
import pl.cantabo.database.group.GroupDAO;
import pl.cantabo.database.playlist.playlistCategory.PlaylistCategoryDAO;
import pl.cantabo.database.slide.SlideDAO;
import pl.cantabo.database.song.SongDAO;

import javax.validation.constraints.NotEmpty;
import java.util.List;
import java.util.Set;
import java.util.UUID;

@Builder
@Entity
@EqualsAndHashCode(callSuper = false)
@Data
@Table(name = "playlists")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id", scope = PlaylistDAO.class)
public class PlaylistDAO  extends Auditable<UUID>  {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column(columnDefinition = "text", nullable = false, unique = true)
    @NotEmpty
    private String name;

    private boolean defaultItem;

    @ManyToMany
    @JoinTable(
            name = "playlistsPlaylistCategories",
            joinColumns = @JoinColumn(name = "playlistId"),
            inverseJoinColumns = @JoinColumn(name = "playlistCategoryId"))
    @OnDelete(action = OnDeleteAction.CASCADE)
    private List<PlaylistCategoryDAO> playlistCategories;

    @ManyToMany
    @JoinTable(
            name = "playlistsSlides",
            joinColumns = @JoinColumn(name = "playlistId"),
            inverseJoinColumns = @JoinColumn(name = "slideId"))
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Set<SlideDAO> slides;

    @ManyToMany
    @JoinTable(
            name = "playlistsSongs",
            joinColumns = @JoinColumn(name = "playlistId"),
            inverseJoinColumns = @JoinColumn(name = "songId"))
    @OnDelete(action = OnDeleteAction.CASCADE)
    private List<SongDAO> songs;

    @ManyToMany(mappedBy = "playlists")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Set<GroupDAO> groups;

    public PlaylistDAO() {
    }

    public PlaylistDAO(UUID id, String name, boolean defaultItem, List<PlaylistCategoryDAO> playlistCategories, Set<SlideDAO> slides, List<SongDAO> songs, Set<GroupDAO> groups) {
        this.id = id;
        this.name = name;
        this.defaultItem = defaultItem;
        this.playlistCategories = playlistCategories;
        this.slides = slides;
        this.songs = songs;
        this.groups = groups;
    }
}
