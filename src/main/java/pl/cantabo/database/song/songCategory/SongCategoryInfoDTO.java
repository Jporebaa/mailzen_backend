package pl.cantabo.database.song.songCategory;

import lombok.Data;

import java.util.UUID;

@Data
public class SongCategoryInfoDTO {

    private UUID id;

    private String name;
}
