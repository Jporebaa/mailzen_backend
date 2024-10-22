package pl.cantabo.database.slide;

import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface SlideRepository extends JpaRepository<SlideDAO, UUID> {

    @Query("SELECT s FROM SlideDAO s WHERE s.song.id = :songId")
    List<SlideDAO> findSlidesBySongId(@Param("songId") UUID songId);

    @Transactional
    @Modifying
    @Query("DELETE FROM SlideDAO s WHERE s.song.id = :songId")
    void deleteSlidesBySongId(@Param("songId") UUID songId);

    @Modifying
    @Query(value = "INSERT INTO slides (id, item_order, body, default_item, song_id) VALUES (:id, :itemOrder, :body, :defaultItem, :songId) ON CONFLICT DO NOTHING", nativeQuery = true)
    void insertSlide(
            @Param("id") UUID id,
            @Param("itemOrder") int itemOrder,
            @Param("body") String body,
            @Param("defaultItem") boolean defaultItem,
            @Param("songId") UUID songId
    );
}
