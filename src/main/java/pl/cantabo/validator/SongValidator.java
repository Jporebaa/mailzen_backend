package pl.cantabo.validator;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import pl.cantabo.database.song.SongDAO;
import pl.cantabo.database.song.SongRepository;

import javax.validation.ValidationException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Component
@RequiredArgsConstructor
public class SongValidator {

    private final SongRepository songRepository;

    public boolean checkIfSameSong(UUID id, SongDAO song) {
        Optional<SongDAO> foundSong = songRepository.findByName(song.getName());
        return foundSong.isPresent() && foundSong.get().getId().equals(id);
    }

    public void validateSong(SongDAO song, boolean isSameSong) {
        List<String> validationErrors = new ArrayList<>();

        if (song.getName() == null || song.getName().isEmpty()) {
            validationErrors.add("Nazwa pieśni nie może być pusta\n");
        }

        if (!isSameSong) {
            if (songRepository.findByName(song.getName()).isPresent()) {
                validationErrors.add("Pieśń o podanej nazwie już istnieje\n");
            }
        }

        if (!validationErrors.isEmpty()) {
            String errorMessage = String.join("", validationErrors);
            throw new ValidationException(errorMessage);
        }
    }
}
