package pl.cantabo.database.group;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface GroupRepository extends JpaRepository<GroupDAO, UUID> {

    Optional<GroupDAO> findByName(String name);

    @Query("SELECT COUNT(g) FROM GroupDAO g")
    int countGroups();
}
