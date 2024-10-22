package pl.cantabo.database.profile;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import pl.cantabo.auditor.Auditable;
import pl.cantabo.database.group.GroupDAO;

import javax.validation.constraints.NotEmpty;
import java.util.UUID;

@Entity
@Builder
@EqualsAndHashCode(callSuper = false)
@Data
@Table(name = "profiles")
public class ProfileDAO  extends Auditable<UUID>  {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column(columnDefinition = "text",  nullable = false, unique = true)
    @NotEmpty
    private String name;

    private boolean active;

    private boolean sortByUsed;

    private String bgColor;

    private String txColor;

    private String stopColor;

    private String fontStyle;

    private double margin;

    private double maxFont;

    private double maxMin;

    private String align;

    private String algorithmRange;

    private boolean showTitle;

    private boolean allBig;

    private boolean showEmptySlide;

    private boolean invertColors;

    private boolean expandedList;

    private boolean defaultItem;

    @ManyToOne
    @JoinColumn(name = "groupId")
    private GroupDAO group;

    public ProfileDAO() {
    }

    public ProfileDAO(UUID id, String name, boolean active, boolean sortByUsed, String bgColor, String txColor, String stopColor, String fontStyle, double margin, double maxFont, double maxMin, String align, String algorithmRange, boolean showTitle, boolean allBig, boolean showEmptySlide, boolean invertColors, boolean expandedList, boolean defaultItem, GroupDAO group) {
        this.id = id;
        this.name = name;
        this.active = active;
        this.sortByUsed = sortByUsed;
        this.bgColor = bgColor;
        this.txColor = txColor;
        this.stopColor = stopColor;
        this.fontStyle = fontStyle;
        this.margin = margin;
        this.maxFont = maxFont;
        this.maxMin = maxMin;
        this.align = align;
        this.algorithmRange = algorithmRange;
        this.showTitle = showTitle;
        this.allBig = allBig;
        this.showEmptySlide = showEmptySlide;
        this.invertColors = invertColors;
        this.expandedList = expandedList;
        this.defaultItem = defaultItem;
        this.group = group;
    }
}
