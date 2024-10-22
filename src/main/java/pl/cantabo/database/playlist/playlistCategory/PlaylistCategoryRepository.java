package pl.cantabo.database.playlist.playlistCategory;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface PlaylistCategoryRepository extends JpaRepository<PlaylistCategoryDAO, UUID> {

    Optional<PlaylistCategoryDAO> findByName(String name);

    @Query("SELECT pc FROM PlaylistCategoryDAO pc JOIN pc.playlists p WHERE p.id = :playlistId")
    List<PlaylistCategoryDAO> findPlaylistCategoriesByPlaylistId(UUID playlistId);

    @Modifying
    @Query(value = "INSERT INTO playlist_categories (id, name, default_item) " +
            "VALUES (:id, :name, :defaultItem) ON CONFLICT DO NOTHING", nativeQuery = true)
    void insertPlaylistCategory(
            @Param("id") UUID id,
            @Param("name") String name,
            @Param("defaultItem") boolean defaultItem
    );

    @Modifying
    @Query(value = "INSERT INTO playlists_playlist_categories (playlist_id, playlist_category_id) " +
            "VALUES (:playlistId, :playlistCategoryId) ON CONFLICT DO NOTHING", nativeQuery = true)
    void insertPlaylistPlaylistCategory(
            @Param("playlistId") UUID playlistId,
            @Param("playlistCategoryId") UUID playlistCategoryId
    );
}

