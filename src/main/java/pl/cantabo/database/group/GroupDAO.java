package pl.cantabo.database.group;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import pl.cantabo.auditor.Auditable;
import pl.cantabo.database.playlist.PlaylistDAO;
import pl.cantabo.database.playlist.playlistCategory.PlaylistCategoryDAO;
import pl.cantabo.database.profile.ProfileDAO;
import pl.cantabo.database.slide.SlideDAO;
import pl.cantabo.database.song.SongDAO;
import pl.cantabo.database.song.songCategory.SongCategoryDAO;
import pl.cantabo.database.user.UserDAO;

import javax.validation.constraints.NotEmpty;
import java.util.Set;
import java.util.UUID;

@Builder
@Entity
@EqualsAndHashCode(callSuper = false)
@Data
@Table(name = "groups")
public class GroupDAO extends Auditable<UUID> {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column(columnDefinition = "text", nullable = false, unique = true)
    @NotEmpty
    private String name;

    private boolean defaultItem;

    @ManyToMany
    @JoinTable(
            name = "groupsSongs",
            joinColumns = @JoinColumn(name = "groupId"),
            inverseJoinColumns = @JoinColumn(name = "songId"))
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Set<SongDAO> songs;

    @ManyToMany
    @JoinTable(
            name = "groupsSongCategories",
            joinColumns = @JoinColumn(name = "groupId"),
            inverseJoinColumns = @JoinColumn(name = "songCategoryId"))
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Set<SongCategoryDAO> songCategories;

    @ManyToMany
    @JoinTable(
            name = "groupsSlides",
            joinColumns = @JoinColumn(name = "groupId"),
            inverseJoinColumns = @JoinColumn(name = "slideId"))
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Set<SlideDAO> slides;

    @ManyToMany
    @JoinTable(
            name = "groupsPlaylists",
            joinColumns = @JoinColumn(name = "groupId"),
            inverseJoinColumns = @JoinColumn(name = "playlistId"))
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Set<PlaylistDAO> playlists;

    @ManyToMany
    @JoinTable(
            name = "groupsPlaylistCategories",
            joinColumns = @JoinColumn(name = "groupId"),
            inverseJoinColumns = @JoinColumn(name = "playlistCategoryId"))
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Set<PlaylistCategoryDAO> playlistCategories;

    @OneToMany(mappedBy = "group")
    private Set<UserDAO> users;

    @OneToMany(mappedBy = "group")
    private Set<ProfileDAO> profiles;

    public GroupDAO() {
    }

    public GroupDAO(UUID id, String name, boolean defaultItem, Set<SongDAO> songs, Set<SongCategoryDAO> songCategories, Set<SlideDAO> slides, Set<PlaylistDAO> playlists, Set<PlaylistCategoryDAO> playlistCategories, Set<UserDAO> users, Set<ProfileDAO> profiles) {
        this.id = id;
        this.name = name;
        this.defaultItem = defaultItem;
        this.songs = songs;
        this.songCategories = songCategories;
        this.slides = slides;
        this.playlists = playlists;
        this.playlistCategories = playlistCategories;
        this.users = users;
        this.profiles = profiles;
    }
}
