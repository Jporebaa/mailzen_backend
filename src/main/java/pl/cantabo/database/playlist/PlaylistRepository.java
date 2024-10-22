package pl.cantabo.database.playlist;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface PlaylistRepository extends JpaRepository<PlaylistDAO, UUID> {

    Optional<PlaylistDAO> findByName(String name);

    @Query("SELECT COUNT(p) FROM PlaylistDAO p")
    int countPlaylists();

    @Query("SELECT p FROM PlaylistDAO p JOIN p.playlistCategories pc WHERE pc.id = :categoryId")
    List<PlaylistDAO> findPlaylistsByCategoryId(UUID categoryId);

    @Modifying
    @Query(value = "INSERT INTO playlists (id, name, default_item) " +
            "VALUES (:id, :name, :defaultItem) ON CONFLICT DO NOTHING", nativeQuery = true)
    void insertPlaylist(
            @Param("id") UUID id,
            @Param("name") String name,
            @Param("defaultItem") boolean defaultItem
    );

    @Modifying
    @Query(value = "INSERT INTO playlists_songs (playlist_id, song_id) " +
            "VALUES (:playlistId, :songId) ON CONFLICT DO NOTHING", nativeQuery = true)
    void insertPlaylistSong(
            @Param("playlistId") UUID playlistId,
            @Param("songId") UUID songId
    );
}
