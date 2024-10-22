package pl.cantabo.validator;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import pl.cantabo.database.playlist.PlaylistDAO;
import pl.cantabo.database.playlist.PlaylistRepository;

import javax.validation.ValidationException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Component
@RequiredArgsConstructor
public class PlaylistValidator {

    private final PlaylistRepository playlistRepository;

    public boolean checkIfSamePlaylist(UUID id, PlaylistDAO playlist) {
        Optional<PlaylistDAO> foundPlaylist = playlistRepository.findByName(playlist.getName());
        return foundPlaylist.isPresent() && foundPlaylist.get().getId().equals(id);
    }

    public void validatePlaylist(PlaylistDAO playlist, boolean isSamePlaylist) {
        List<String> validationErrors = new ArrayList<>();

        if (playlist.getName() == null || playlist.getName().isEmpty()) {
            validationErrors.add("Nazwa playlisty nie może być pusta\n");
        }

        if (!isSamePlaylist) {
            if (playlistRepository.findByName(playlist.getName()).isPresent()) {
                validationErrors.add("Playlista o podanej nazwie już istnieje\n");
            }
        }

        if (!validationErrors.isEmpty()) {
            String errorMessage = String.join("", validationErrors);
            throw new ValidationException(errorMessage);
        }
    }
}
