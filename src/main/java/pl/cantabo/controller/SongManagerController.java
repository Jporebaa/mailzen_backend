package pl.cantabo.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.*;
import pl.cantabo.database.slide.SlideCreateDTO;
import pl.cantabo.database.slide.SlideInfoDTO;
import pl.cantabo.database.slide.SlideMapper;
import pl.cantabo.database.song.SongDAO;
import pl.cantabo.database.song.SongInfoDTO;
import pl.cantabo.database.song.SongMapper;
import pl.cantabo.database.song.songCategory.SongCategoryInfoDTO;
import pl.cantabo.database.song.songCategory.SongCategoryMapper;
import pl.cantabo.service.SlideService;
import pl.cantabo.service.SongService;

import javax.validation.Valid;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Log4j2
@RestController
@RequestMapping("/dashboard/songManager")
@RequiredArgsConstructor
@CrossOrigin
public class SongManagerController {

    private final SongService songService;
    private final SongMapper songMapper;
    private final SlideMapper slideMapper;
    private final SongCategoryMapper songCategoryMapper;
    private final SlideService slideService;

    @PostMapping
    public SongInfoDTO createSong(@RequestBody @Valid SongAndSlideCreateRequestDTO songAndSlide) {
        log.debug("Create songAndSlide {}", songAndSlide);
        SongDAO toCreate = songMapper.songCreateDTO2SongDAO(songAndSlide.getSong());
        SongDAO createdSong = songService.create(toCreate);
        if (songAndSlide.getSlides() != null && !songAndSlide.getSlides().isEmpty()) {
            createSlidesAndAssignToSong(toCreate, songAndSlide.getSlides());
        }
        return log.traceExit(songMapper.songDAO2SongInfoDTO(createdSong));
    }

    private void createSlidesAndAssignToSong(SongDAO songDAO, List<SlideCreateDTO> slideCreateDTOs) {
        slideCreateDTOs.stream()
                .map(slideMapper::slideCreateDTO2SlideDAO)
                .peek(slideDAO -> slideDAO.setSong(songDAO))
                .forEach(slideService::create);
    }

    @PutMapping("{id}")
    public SongInfoDTO updateSong(@RequestBody @Valid SongAndSlideUpdateRequestDTO songAndSlide, @PathVariable UUID id) {
        log.debug("Update song {}: {}", id, songAndSlide);
        SongDAO updatedSong = songService.update(id, songMapper.songUpdateDTO2SongDAO(songAndSlide.getSong()));
        slideService.deleteSlidesBySongId(id);
        if (songAndSlide.getSlides() != null && !songAndSlide.getSlides().isEmpty()) {
            updateSlidesAndAssignToSong(updatedSong, songAndSlide.getSlides());
        }
        return log.traceExit(songMapper.songDAO2SongInfoDTO(updatedSong));
    }

    private void updateSlidesAndAssignToSong(SongDAO songDAO, List<SlideCreateDTO> slideUpdateDTOs) {
        slideUpdateDTOs.stream()
                .map(slideMapper::slideCreateDTO2SlideDAO)
                .peek(slideDAO -> slideDAO.setSong(songDAO))
                .forEach(slideService::create);
    }

    @GetMapping("/songCategoriesForSong/{id}")
    public List<SongCategoryInfoDTO> getSongCategoriesForSong(@PathVariable UUID id) {
        log.debug("Getting song categories for song");
        return log.traceExit(
                songService.getSongCategoriesBySongId(id)
                        .stream()
                        .map(songCategoryMapper::songCategoryDAO2SongCategoryInfoDTO)
                        .collect(Collectors.toList())
        );
    }

    @GetMapping("/slidesForSong/{id}")
    public List<SlideInfoDTO> getSlidesForSong(@PathVariable UUID id) {
        log.debug("Getting slides for song");
        return log.traceExit(
                songService.getSlidesBySongId(id)
                        .stream()
                        .map(slideMapper::slideDAO2SlideInfoDTO)
                        .collect(Collectors.toList())
        );
    }
}
