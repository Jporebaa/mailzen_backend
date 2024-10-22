package pl.cantabo.validator;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import pl.cantabo.database.playlist.playlistCategory.PlaylistCategoryDAO;
import pl.cantabo.database.playlist.playlistCategory.PlaylistCategoryRepository;

import javax.validation.ValidationException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Component
@RequiredArgsConstructor
public class PlaylistCategoryValidator {

    private final PlaylistCategoryRepository playlistCategoryRepository;

    public boolean checkIfSameCategory(UUID id, PlaylistCategoryDAO playlistCategory) {
        Optional<PlaylistCategoryDAO> foundCategory = playlistCategoryRepository.findByName(playlistCategory.getName());
        return foundCategory.isPresent() && foundCategory.get().getId().equals(id);
    }

    public void validatePlaylistCategory(PlaylistCategoryDAO playlistCategory, boolean isSameCategory) {
        List<String> validationErrors = new ArrayList<>();

        if (playlistCategory.getName() == null || playlistCategory.getName().isEmpty()) {
            validationErrors.add("Nazwa kategorii playlisty nie może być pusta\n");
        }

        if (!isSameCategory) {
            if (playlistCategoryRepository.findByName(playlistCategory.getName()).isPresent()) {
                validationErrors.add("Kategoria playlisty o podanej nazwie już istnieje\n");
            }
        }

        if (!validationErrors.isEmpty()) {
            String errorMessage = String.join("", validationErrors);
            throw new ValidationException(errorMessage);
        }
    }
}
