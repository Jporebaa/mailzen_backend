package pl.cantabo.database.song.songCategory;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface SongCategoryRepository extends JpaRepository<SongCategoryDAO, UUID> {

    @Query("SELECT sc FROM SongCategoryDAO sc WHERE sc.name LIKE %:nameFragment%")
    List<SongCategoryDAO> findSongCategoryByName(String nameFragment);

    Optional<SongCategoryDAO> findByName(String name);

    @Query("SELECT sc FROM SongCategoryDAO sc JOIN sc.songs s WHERE s.id = :songId")
    List<SongCategoryDAO> findSongCategoriesBySongId(UUID songId);

    @Modifying
    @Query(value = "INSERT INTO song_categories (id, name, default_item) " +
            "VALUES (:id, :name, :defaultItem) ON CONFLICT DO NOTHING", nativeQuery = true)
    void insertSongCategory(
            @Param("id") UUID id,
            @Param("name") String name,
            @Param("defaultItem") boolean defaultItem
    );

    @Modifying
    @Query(value = "INSERT INTO songs_song_categories (song_id, category_id) " +
            "VALUES (:songId, :categoryId) ON CONFLICT DO NOTHING", nativeQuery = true)
    void insertSongSongCategory(
            @Param("songId") UUID songId,
            @Param("categoryId") UUID categoryId
    );
}
