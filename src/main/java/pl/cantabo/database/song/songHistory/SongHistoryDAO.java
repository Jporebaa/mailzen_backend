package pl.cantabo.database.song.songHistory;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import pl.cantabo.auditor.Auditable;
import pl.cantabo.database.song.SongDAO;

import java.util.Calendar;
import java.util.UUID;

@Entity
@Builder
@EqualsAndHashCode(callSuper = false)
@Data
@Table(name = "songHistories")
public class SongHistoryDAO extends Auditable<UUID> {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    private Calendar scheduledDate;

    @ManyToOne
    @JoinColumn(name = "songId")
    private SongDAO song;

    public SongHistoryDAO() {
    }

    public SongHistoryDAO(UUID id, Calendar scheduledDate, SongDAO song) {
        this.id = id;
        this.scheduledDate = scheduledDate;
        this.song = song;
    }
}
