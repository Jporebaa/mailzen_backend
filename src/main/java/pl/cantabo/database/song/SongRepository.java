package pl.cantabo.database.song;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface SongRepository extends JpaRepository<SongDAO, UUID> {

    Optional<SongDAO> findByName(String name);

    @Query("SELECT s FROM SongDAO s JOIN s.playlists p WHERE p.id = :playlistId")
    List<SongDAO> findSongsByPlaylistId(@Param("playlistId") UUID playlistId);

    @Query("SELECT s FROM SongDAO s JOIN s.songCategories sc WHERE sc.id = :categoryId")
    List<SongDAO> findSongsByCategoryId(UUID categoryId);

    @Query("SELECT COUNT(s) FROM SongDAO s")
    int countSongs();

    @Modifying
    @Query(value = "INSERT INTO songs (id, name, view_counter, default_item) VALUES (:id, :name, :viewCounter, :defaultItem) ON CONFLICT DO NOTHING", nativeQuery = true)
    void insertSong(
            @Param("id") UUID id,
            @Param("name") String name,
            @Param("viewCounter") int viewCounter,
            @Param("defaultItem") boolean defaultItem
    );
}
