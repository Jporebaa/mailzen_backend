package pl.cantabo.initializer;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import pl.cantabo.database.playlist.PlaylistRepository;

import java.util.UUID;

@Component
@RequiredArgsConstructor
public class PlaylistSongInitializer {

    private final PlaylistRepository playlistRepository;

    public void initialize() {
        // Pasterka
        playlistRepository.insertPlaylistSong(
                UUID.fromString("e0a1cd9f-fafd-4766-af94-489ec23006d8"),
                UUID.fromString("03795b7f-1ffc-4d46-a012-171d63f34d8e")
        );

        playlistRepository.insertPlaylistSong(
                UUID.fromString("e0a1cd9f-fafd-4766-af94-489ec23006d8"),
                UUID.fromString("5e66a7cd-4f7a-4f14-a66b-96bde53627d1")
        );

        playlistRepository.insertPlaylistSong(
                UUID.fromString("e0a1cd9f-fafd-4766-af94-489ec23006d8"),
                UUID.fromString("4f6b7d3d-3490-4eb7-a1c5-2c948d8a2c50")
        );

        playlistRepository.insertPlaylistSong(
                UUID.fromString("e0a1cd9f-fafd-4766-af94-489ec23006d8"),
                UUID.fromString("1e5dccfd-022b-40d7-87af-5809bdb137a0")
        );

        // Droga Krzyżowa - Wielki Piątek
        playlistRepository.insertPlaylistSong(
                UUID.fromString("2d0ea284-1288-4c8c-8bfb-0810a0f633de"),
                UUID.fromString("8c9dc5e1-605c-416a-9405-57058c007076")
        );

        playlistRepository.insertPlaylistSong(
                UUID.fromString("2d0ea284-1288-4c8c-8bfb-0810a0f633de"),
                UUID.fromString("b77433fb-2e21-4fef-abff-8e1637456c0e")
        );

        playlistRepository.insertPlaylistSong(
                UUID.fromString("2d0ea284-1288-4c8c-8bfb-0810a0f633de"),
                UUID.fromString("789bd035-b492-4b26-9588-a671fe091d16")
        );

        // Rekolekcje Adwentowe
        playlistRepository.insertPlaylistSong(
                UUID.fromString("a1b9b561-588e-4a4c-8f44-382fcd1a52ca"),
                UUID.fromString("dd51c3f7-6716-40ff-af45-d0ae81a7751b")
        );

        playlistRepository.insertPlaylistSong(
                UUID.fromString("a1b9b561-588e-4a4c-8f44-382fcd1a52ca"),
                UUID.fromString("21543c8c-6c5e-4fe7-a140-78c0a52470e3")
        );

        playlistRepository.insertPlaylistSong(
                UUID.fromString("a1b9b561-588e-4a4c-8f44-382fcd1a52ca"),
                UUID.fromString("71db877c-6d94-40e8-9dbb-d92c80162832")
        );

        // Adoracja Najświętszego Sakramentu
        playlistRepository.insertPlaylistSong(
                UUID.fromString("20158e2a-9de4-4067-a62b-c7f0e66e167c"),
                UUID.fromString("1a03f4fe-a53a-435c-9a4e-fffc0819cdb0")
        );

        playlistRepository.insertPlaylistSong(
                UUID.fromString("20158e2a-9de4-4067-a62b-c7f0e66e167c"),
                UUID.fromString("f4bb4062-dce9-4086-b02c-7c933d8e7745")
        );

        playlistRepository.insertPlaylistSong(
                UUID.fromString("20158e2a-9de4-4067-a62b-c7f0e66e167c"),
                UUID.fromString("af0b1fe7-6889-4314-8de1-9361b2c78e7e")
        );

        // II Niedziela okresu Wielkanocnego
        playlistRepository.insertPlaylistSong(
                UUID.fromString("faa35a7d-3051-415d-a64f-e9919334e75b"),
                UUID.fromString("60c81edc-a645-4fa6-9413-e32c71ad96a7")
        );

        playlistRepository.insertPlaylistSong(
                UUID.fromString("faa35a7d-3051-415d-a64f-e9919334e75b"),
                UUID.fromString("f127ab80-84ee-4d26-a6ff-573d27b451de")
        );

        playlistRepository.insertPlaylistSong(
                UUID.fromString("faa35a7d-3051-415d-a64f-e9919334e75b"),
                UUID.fromString("af0b1fe7-6889-4314-8de1-9361b2c78e7e")
        );
    }
}
