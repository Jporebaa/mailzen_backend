package pl.cantabo.controller;

import lombok.Data;
import pl.cantabo.database.slide.SlideCreateDTO;
import pl.cantabo.database.song.SongUpdateDTO;

import javax.validation.Valid;
import java.util.List;

@Data
public class SongAndSlideUpdateRequestDTO {

    @Valid
    private SongUpdateDTO song;

    @Valid
    private List<SlideCreateDTO> slides;
}
