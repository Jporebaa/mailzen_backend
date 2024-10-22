package pl.cantabo.controller;

import lombok.Data;
import pl.cantabo.database.slide.SlideCreateDTO;
import pl.cantabo.database.song.SongCreateDTO;

import javax.validation.Valid;
import java.util.List;

@Data
public class SongAndSlideCreateRequestDTO {
    @Valid
    private SongCreateDTO song;

    @Valid
    private List<SlideCreateDTO> slides;
}
