package pl.cantabo.initializer;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import pl.cantabo.database.playlist.playlistCategory.PlaylistCategoryRepository;

import java.util.UUID;

@Component
@RequiredArgsConstructor
public class PlaylistCategoryInitializer {

    private final PlaylistCategoryRepository playlistCategoryRepository;

    public void initialize() {
        playlistCategoryRepository.insertPlaylistCategory(
                UUID.fromString("f2cbf45e-54b8-4e56-8a94-d1b118f810d0"),
                "Msza święta",
                true
        );

        playlistCategoryRepository.insertPlaylistCategory(
                UUID.fromString("6700b4e7-13f0-45c4-b63b-44d446a45a3f"),
                "Rekolekcje",
                true
        );

        playlistCategoryRepository.insertPlaylistCategory(
                UUID.fromString("5e94c08b-8e9a-4f4d-b4d2-df6658a297c6"),
                "Adoracja",
                true
        );

        playlistCategoryRepository.insertPlaylistCategory(
                UUID.fromString("d2f7f61f-7173-4f72-b07a-64c8af5e5e06"),
                "Droga Krzyżowa",
                true
        );

        playlistCategoryRepository.insertPlaylistCategory(
                UUID.fromString("4d3819e0-d413-4b89-99e1-2679fbd2e792"),
                "Kolędy",
                true
        );
    }
}
