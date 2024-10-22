package pl.cantabo.validator;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import pl.cantabo.database.song.songCategory.SongCategoryDAO;
import pl.cantabo.database.song.songCategory.SongCategoryRepository;

import javax.validation.ValidationException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Component
@RequiredArgsConstructor
public class SongCategoryValidator {

    private final SongCategoryRepository songCategoryRepository;

    public boolean checkIfSameCategory(UUID id, SongCategoryDAO songCategory) {
        Optional<SongCategoryDAO> foundCategory = songCategoryRepository.findByName(songCategory.getName());
        return foundCategory.isPresent() && foundCategory.get().getId().equals(id);
    }

    public void validateSongCategory(SongCategoryDAO songCategory, boolean isSameCategory) {
        List<String> validationErrors = new ArrayList<>();

        if (songCategory.getName() == null || songCategory.getName().isEmpty()) {
            validationErrors.add("Nazwa kategorii pieśni nie może być pusta\n");
        }

        if (!isSameCategory) {
            if (songCategoryRepository.findByName(songCategory.getName()).isPresent()) {
                validationErrors.add("Kategoria pieśni o podanej nazwie już istnieje\n");
            }
        }

        if (!validationErrors.isEmpty()) {
            String errorMessage = String.join("", validationErrors);
            throw new ValidationException(errorMessage);
        }
    }
}
