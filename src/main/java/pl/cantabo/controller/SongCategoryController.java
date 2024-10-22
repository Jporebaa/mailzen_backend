package pl.cantabo.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.*;
import pl.cantabo.database.song.songCategory.*;
import pl.cantabo.service.SongCategoryService;

import javax.validation.Valid;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Log4j2
@RestController
@RequestMapping("/dashboard/songCategories")
@RequiredArgsConstructor
@CrossOrigin
public class SongCategoryController {

    private final SongCategoryService songCategoryService;
    private final SongCategoryMapper songCategoryMapper;

    @PostMapping
    public SongCategoryInfoDTO createSongCategory(@RequestBody @Valid SongCategoryCreateDTO songCategory) {
        log.debug("Create song category {}", songCategory);
        SongCategoryDAO toCreate = songCategoryMapper.songCategoryCreateDTO2SongCategoryDAO(songCategory);
        SongCategoryDAO createdSongCategory = songCategoryService.create(toCreate);
        return log.traceExit(songCategoryMapper.songCategoryDAO2SongCategoryInfoDTO(createdSongCategory));
    }

    @PutMapping("{id}")
    public SongCategoryInfoDTO updateSongCategory(@RequestBody @Valid SongCategoryUpdateDTO songCategory, @PathVariable UUID id) {
        log.debug("Update song category {}: {}", id, songCategory);
        SongCategoryDAO updatedSongCategory = songCategoryService.update(id, songCategoryMapper.songCategoryUpdateDTO2SongCategoryDAO(songCategory));
        return log.traceExit(songCategoryMapper.songCategoryDAO2SongCategoryInfoDTO(updatedSongCategory));
    }

    @GetMapping
    public List<SongCategoryInfoDTO> getAllCategories() {
        log.debug("Getting all song categories");
        return log.traceExit(
                songCategoryService.getAll()
                        .stream()
                        .map(songCategoryMapper::songCategoryDAO2SongCategoryInfoDTO)
                        .collect(Collectors.toList())
        );
    }

    @DeleteMapping("{id}")
    public void deleteSongCategory(@PathVariable UUID id) {
        log.debug("Deleting song category {}", id);
        songCategoryService.delete(id);
    }
}
