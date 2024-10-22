package pl.cantabo.database.profile;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface ProfileRepository extends JpaRepository<ProfileDAO, UUID> {

    @Query("SELECT p FROM ProfileDAO p WHERE p.name LIKE %:nameFragment%")
    List<ProfileDAO> findProfileByName(String nameFragment);

    Optional<ProfileDAO> findByName(String name);

    @Modifying
    @Query(value = "INSERT INTO profiles (id, name, active, align, all_big, expanded_list, invert_colors, margin, max_font, max_min, show_empty_slide, show_title, sort_by_used, bg_color, stop_color, tx_color, default_item) " +
            "VALUES (:id, :name, :active, :align, :allBig, :expandedList, :invertColors, :margin, :maxFont, :maxMin, :showEmptySlide, :showTitle, :sortByUsed, :bgColor, :stopColor, :txColor, :defaultItem) " +
            "ON CONFLICT DO NOTHING", nativeQuery = true)
    void insertProfile(
            @Param("id") UUID id,
            @Param("name") String name,
            @Param("active") boolean active,
            @Param("align") String align,
            @Param("allBig") boolean allBig,
            @Param("expandedList") boolean expandedList,
            @Param("invertColors") boolean invertColors,
            @Param("margin") int margin,
            @Param("maxFont") int maxFont,
            @Param("maxMin") int maxMin,
            @Param("showEmptySlide") boolean showEmptySlide,
            @Param("showTitle") boolean showTitle,
            @Param("sortByUsed") boolean sortByUsed,
            @Param("bgColor") String bgColor,
            @Param("stopColor") String stopColor,
            @Param("txColor") String txColor,
            @Param("defaultItem") boolean defaultItem
    );
}
