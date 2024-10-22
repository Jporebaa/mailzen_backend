package pl.cantabo.initializer;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import pl.cantabo.database.playlist.playlistCategory.PlaylistCategoryRepository;

import java.util.UUID;

@Component
@RequiredArgsConstructor
public class PlaylistPlaylistCategoryInitializer {

    private final PlaylistCategoryRepository playlistCategoryRepository;

    public void initialize() {
        // Kolędy
        playlistCategoryRepository.insertPlaylistPlaylistCategory(
                UUID.fromString("e0a1cd9f-fafd-4766-af94-489ec23006d8"),
                UUID.fromString("4d3819e0-d413-4b89-99e1-2679fbd2e792")
        );

        // Droga Krzyżowa
        playlistCategoryRepository.insertPlaylistPlaylistCategory(
                UUID.fromString("2d0ea284-1288-4c8c-8bfb-0810a0f633de"),
                UUID.fromString("d2f7f61f-7173-4f72-b07a-64c8af5e5e06")
        );

        // Rekolekcje
        playlistCategoryRepository.insertPlaylistPlaylistCategory(
                UUID.fromString("a1b9b561-588e-4a4c-8f44-382fcd1a52ca"),
                UUID.fromString("6700b4e7-13f0-45c4-b63b-44d446a45a3f")
        );

        // Adoracja
        playlistCategoryRepository.insertPlaylistPlaylistCategory(
                UUID.fromString("20158e2a-9de4-4067-a62b-c7f0e66e167c"),
                UUID.fromString("5e94c08b-8e9a-4f4d-b4d2-df6658a297c6")
        );

        // Msza święta
        playlistCategoryRepository.insertPlaylistPlaylistCategory(
                UUID.fromString("faa35a7d-3051-415d-a64f-e9919334e75b"),
                UUID.fromString("f2cbf45e-54b8-4e56-8a94-d1b118f810d0")
        );
    }
}
