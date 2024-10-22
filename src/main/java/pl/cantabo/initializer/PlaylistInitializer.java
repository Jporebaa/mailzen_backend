package pl.cantabo.initializer;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import pl.cantabo.database.playlist.PlaylistRepository;

import java.util.UUID;

@Component
@RequiredArgsConstructor
public class PlaylistInitializer {

    private final PlaylistRepository playlistRepository;

    public void initialize() {
        playlistRepository.insertPlaylist(
                UUID.fromString("e0a1cd9f-fafd-4766-af94-489ec23006d8"),
                "Pasterka",
                true
        );

        playlistRepository.insertPlaylist(
                UUID.fromString("2d0ea284-1288-4c8c-8bfb-0810a0f633de"),
                "Droga Krzyżowa - Wielki Piątek",
                true
        );

        playlistRepository.insertPlaylist(
                UUID.fromString("a1b9b561-588e-4a4c-8f44-382fcd1a52ca"),
                "Rekolekcje Adwentowe",
                true
        );

        playlistRepository.insertPlaylist(
                UUID.fromString("20158e2a-9de4-4067-a62b-c7f0e66e167c"),
                "Adoracja Najświętszego Sakramentu",
                true
        );

        playlistRepository.insertPlaylist(
                UUID.fromString("faa35a7d-3051-415d-a64f-e9919334e75b"),
                "II Niedziela okresu Wielkanocnego",
                true
        );
    }
}
