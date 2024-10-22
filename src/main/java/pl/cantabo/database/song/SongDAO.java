package pl.cantabo.database.song;

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
import pl.cantabo.database.slide.SlideDAO;
import pl.cantabo.database.song.songCategory.SongCategoryDAO;
import pl.cantabo.database.song.songHistory.SongHistoryDAO;

import javax.validation.constraints.NotEmpty;
import java.util.List;
import java.util.Set;
import java.util.UUID;

@Entity
@Builder
@EqualsAndHashCode(callSuper = false)
@Data
@Table(name = "songs")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id", scope = SongDAO.class)
public class SongDAO extends Auditable<UUID> {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column(columnDefinition = "text", nullable = false, unique = true)
    @NotEmpty
    private String name;

    @Column(columnDefinition = "text")
    private String musicAuthor;

    @Column(columnDefinition = "text")
    private String wordsAuthor;

    private long viewCounter;

    private boolean defaultItem;

    private UUID parentId;

    @ManyToMany
    @JoinTable(
            name = "songsSongCategories",
            joinColumns = @JoinColumn(name = "songId"),
            inverseJoinColumns = @JoinColumn(name = "categoryId"))
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Set<SongCategoryDAO> songCategories;

    @ManyToMany(mappedBy = "songs")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Set<GroupDAO> groups;

    @ManyToMany(mappedBy = "songs")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private List<PlaylistDAO> playlists;

    @OneToMany(mappedBy = "song", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<SlideDAO> slides;

    @OneToMany(mappedBy = "song", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<SongHistoryDAO> songHistory;

    public SongDAO() {
    }

    public SongDAO(UUID id, String name, String musicAuthor, String wordsAuthor, long viewCounter, boolean defaultItem, UUID parentId, Set<SongCategoryDAO> songCategories, Set<GroupDAO> groups, List<PlaylistDAO> playlists, List<SlideDAO> slides, Set<SongHistoryDAO> songHistory) {
        this.id = id;
        this.name = name;
        this.musicAuthor = musicAuthor;
        this.wordsAuthor = wordsAuthor;
        this.viewCounter = viewCounter;
        this.defaultItem = defaultItem;
        this.parentId = parentId;
        this.songCategories = songCategories;
        this.groups = groups;
        this.playlists = playlists;
        this.slides = slides;
        this.songHistory = songHistory;
    }
}
