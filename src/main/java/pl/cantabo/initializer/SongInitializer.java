package pl.cantabo.initializer;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import pl.cantabo.database.song.SongRepository;

import java.util.UUID;

@Component
@RequiredArgsConstructor
public class SongInitializer {

    private final SongRepository songRepository;

    public void initialize() {
        // Adwent
        songRepository.insertSong(
                UUID.fromString("dd51c3f7-6716-40ff-af45-d0ae81a7751b"),
                "Bliskie jest Królestwo Boże",
                0,
                true
        );

        songRepository.insertSong(
                UUID.fromString("21543c8c-6c5e-4fe7-a140-78c0a52470e3"),
                "Archanioł Boży Gabriel",
                0,
                true
        );

        songRepository.insertSong(
                UUID.fromString("71db877c-6d94-40e8-9dbb-d92c80162832"),
                "Spuśćcie nam na ziemskie niwy",
                0,
                true
        );

        // Boże Narodzenie
        songRepository.insertSong(
                UUID.fromString("03795b7f-1ffc-4d46-a012-171d63f34d8e"),
                "Wśród nocnej ciszy",
                0,
                true
        );

        songRepository.insertSong(
                UUID.fromString("5e66a7cd-4f7a-4f14-a66b-96bde53627d1"),
                "Dzisiaj w Betlejem",
                0,
                true
        );

        songRepository.insertSong(
                UUID.fromString("4f6b7d3d-3490-4eb7-a1c5-2c948d8a2c50"),
                "Przybieżeli do Betlejem pasterze",
                0,
                true
        );

        songRepository.insertSong(
                UUID.fromString("1e5dccfd-022b-40d7-87af-5809bdb137a0"),
                "Bóg się rodzi",
                0,
                true
        );

        // Wielki Post
        songRepository.insertSong(
                UUID.fromString("8c9dc5e1-605c-416a-9405-57058c007076"),
                "Ach, mój Jezu",
                0,
                true
        );

        songRepository.insertSong(
                UUID.fromString("b77433fb-2e21-4fef-abff-8e1637456c0e"),
                "Pewnej nocy",
                0,
                true
        );

        songRepository.insertSong(
                UUID.fromString("789bd035-b492-4b26-9588-a671fe091d16"),
                "Rozpięty na ramionach",
                0,
                true
        );

        // Wielkanoc
        songRepository.insertSong(
                UUID.fromString("60c81edc-a645-4fa6-9413-e32c71ad96a7"),
                "Nie zna śmierci Pan żywota",
                0,
                true
        );

        // Okres zwykły
        songRepository.insertSong(
                UUID.fromString("1a03f4fe-a53a-435c-9a4e-fffc0819cdb0"),
                "Abba Ojcze",
                0,
                true
        );

        songRepository.insertSong(
                UUID.fromString("af0b1fe7-6889-4314-8de1-9361b2c78e7e"),
                "Bądźże pozdrowiona",
                0,
                true
        );

        songRepository.insertSong(
                UUID.fromString("f127ab80-84ee-4d26-a6ff-573d27b451de"),
                "Wszystko Tobie oddać pragnę",
                0,
                true
        );

        // Psalmy
        songRepository.insertSong(
                UUID.fromString("f4bb4062-dce9-4086-b02c-7c933d8e7745"),
                "Psalm 23",
                0,
                true
        );
    }
}
