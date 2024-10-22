package pl.cantabo.database.song;

import lombok.Data;

import java.util.UUID;

@Data
public class SongInfoDTO {

    private UUID id;

    private String name;

    private String musicAuthor;

    private String wordsAuthor;
}
