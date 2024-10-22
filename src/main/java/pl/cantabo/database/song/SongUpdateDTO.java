package pl.cantabo.database.song;

import lombok.Data;
import pl.cantabo.database.song.songCategory.SongCategoryDAO;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.List;

@Data
public class SongUpdateDTO {

    @NotBlank
    @Size(min = 1, max = 100)
    private String name;

    @Size(min = 1, max = 100)
    private String musicAuthor;

    @Size(min = 1, max = 100)
    private String wordsAuthor;

    private List<SongCategoryDAO> songCategories;
}
