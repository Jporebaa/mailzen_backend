package pl.cantabo.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.cantabo.database.playlist.playlistCategory.PlaylistCategoryDAO;
import pl.cantabo.database.playlist.playlistCategory.PlaylistCategoryRepository;
import pl.cantabo.validator.PlaylistCategoryValidator;

import javax.validation.ValidationException;
import java.util.List;
import java.util.UUID;

@Service
@Log4j2
@RequiredArgsConstructor
public class PlaylistCategoryService {
    private final PlaylistCategoryRepository playlistCategoryRepository;
    private final PlaylistCategoryValidator playlistCategoryValidator;

    @Transactional
    public PlaylistCategoryDAO create(PlaylistCategoryDAO playlistCategory){
        log.debug("Creating playlist category{}", playlistCategory);
        playlistCategoryValidator.validatePlaylistCategory(playlistCategory, false);
        return log.traceExit(playlistCategoryRepository.save(playlistCategory));
    }

    @Transactional
    public PlaylistCategoryDAO update(UUID id, PlaylistCategoryDAO playlistCategory) {
        log.debug("Updating playlist category {}: {}", id, playlistCategory);
        boolean isSameCategory = playlistCategoryValidator.checkIfSameCategory(id, playlistCategory);
        playlistCategoryValidator.validatePlaylistCategory(playlistCategory, isSameCategory);
        PlaylistCategoryDAO toUpdate = playlistCategoryRepository.findById(id).orElseThrow(() -> new ValidationException("Kategoria playlisty o podanym id nie istnieje"));
        toUpdate.setName(playlistCategory.getName());
        return log.traceExit(playlistCategoryRepository.save(toUpdate));
    }

    public void delete(UUID id ){
        log.debug("Deleting playlist category{}", id);
        playlistCategoryRepository.deleteById(id);
    }

    public List<PlaylistCategoryDAO> getAll(){
        log.debug("Getting all playlist categories");
        return log.traceExit(playlistCategoryRepository.findAll());
    }
}
