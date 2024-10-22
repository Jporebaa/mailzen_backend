package pl.cantabo.database.playlist.playlistCategory;

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
import pl.cantabo.database.playlist.PlaylistDAO;

import javax.validation.constraints.NotEmpty;
import java.util.List;
import java.util.Set;
import java.util.UUID;

@Data
@Entity
@Builder
@EqualsAndHashCode(callSuper = false)
@Table(name = "playlistCategories")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id", scope = PlaylistCategoryDAO.class)
public class PlaylistCategoryDAO extends Auditable<UUID> {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column(columnDefinition = "text",  nullable = false, unique = true)
    @NotEmpty
    private String name;

    private boolean defaultItem;

    @ManyToMany(mappedBy = "playlistCategories")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private List<PlaylistDAO> playlists;

    @ManyToMany(mappedBy = "playlistCategories")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Set<GroupDAO> groups;

    public PlaylistCategoryDAO() {
    }

    public PlaylistCategoryDAO(UUID id, @NotEmpty String name, boolean defaultItem, List<PlaylistDAO> playlists, Set<GroupDAO> groups) {
        this.id = id;
        this.name = name;
        this.defaultItem = defaultItem;
        this.playlists = playlists;
        this.groups = groups;
    }
}
