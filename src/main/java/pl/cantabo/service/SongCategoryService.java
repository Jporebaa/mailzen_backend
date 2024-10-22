package pl.cantabo.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.cantabo.database.song.songCategory.SongCategoryDAO;
import pl.cantabo.database.song.songCategory.SongCategoryRepository;
import pl.cantabo.validator.SongCategoryValidator;

import javax.validation.ValidationException;
import java.util.List;
import java.util.UUID;

@Service
@Log4j2
@RequiredArgsConstructor
public class SongCategoryService {

    private final SongCategoryRepository songCategoryRepository;
    private final SongCategoryValidator songCategoryValidator;

    @Transactional
    public SongCategoryDAO create(SongCategoryDAO songCategory) {
        log.debug("Creating song category {}", songCategory);
        songCategoryValidator.validateSongCategory(songCategory, false);
        return log.traceExit(songCategoryRepository.save(songCategory));
    }

    @Transactional
    public SongCategoryDAO update(UUID id, SongCategoryDAO songCategory) {
        log.debug("Updating song category {}: {}", id, songCategory);
        boolean isSameCategory = songCategoryValidator.checkIfSameCategory(id, songCategory);
        songCategoryValidator.validateSongCategory(songCategory, isSameCategory);
        SongCategoryDAO toUpdate = songCategoryRepository.findById(id).orElseThrow(() -> new ValidationException("Kategoria pieśni o podanym id nie istnieje"));
        toUpdate.setName(songCategory.getName());
        return log.traceExit(songCategoryRepository.save(toUpdate));
    }

    public void delete(UUID id) {
        log.debug("Deleting song category {}", id);
        songCategoryRepository.deleteById(id);
    }

    public List<SongCategoryDAO> getAll() {
        log.debug("Getting all song categories");
        return log.traceExit(songCategoryRepository.findAll());
    }
}
