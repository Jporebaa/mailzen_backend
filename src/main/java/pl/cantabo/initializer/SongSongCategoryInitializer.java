package pl.cantabo.initializer;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import pl.cantabo.database.song.songCategory.SongCategoryRepository;

import java.util.UUID;

@Component
@RequiredArgsConstructor
public class SongSongCategoryInitializer {

    private final SongCategoryRepository songCategoryRepository;

    public void initialize() {
        // Adwent
        songCategoryRepository.insertSongSongCategory(
                UUID.fromString("dd51c3f7-6716-40ff-af45-d0ae81a7751b"),
                UUID.fromString("f2cbf45e-54b7-4e56-8a94-d1b118f810d0")
        );

        songCategoryRepository.insertSongSongCategory(
                UUID.fromString("21543c8c-6c5e-4fe7-a140-78c0a52470e3"),
                UUID.fromString("f2cbf45e-54b7-4e56-8a94-d1b118f810d0")
        );

        songCategoryRepository.insertSongSongCategory(
                UUID.fromString("71db877c-6d94-40e8-9dbb-d92c80162832"),
                UUID.fromString("f2cbf45e-54b7-4e56-8a94-d1b118f810d0")
        );

        // Boże Narodzenie
        songCategoryRepository.insertSongSongCategory(
                UUID.fromString("03795b7f-1ffc-4d46-a012-171d63f34d8e"),
                UUID.fromString("6700b4e7-13f0-45c4-b63b-44d446a45a3f")
        );

        songCategoryRepository.insertSongSongCategory(
                UUID.fromString("5e66a7cd-4f7a-4f14-a66b-96bde53627d1"),
                UUID.fromString("6700b4e7-13f0-45c4-b63b-44d446a45a3f")
        );

        songCategoryRepository.insertSongSongCategory(
                UUID.fromString("4f6b7d3d-3490-4eb7-a1c5-2c948d8a2c50"),
                UUID.fromString("6700b4e7-13f0-45c4-b63b-44d446a45a3f")
        );

        songCategoryRepository.insertSongSongCategory(
                UUID.fromString("1e5dccfd-022b-40d7-87af-5809bdb137a0"),
                UUID.fromString("6700b4e7-13f0-45c4-b63b-44d446a45a3f")
        );

        // Wielki Post
        songCategoryRepository.insertSongSongCategory(
                UUID.fromString("8c9dc5e1-605c-416a-9405-57058c007076"),
                UUID.fromString("5e94c08b-8e9a-4f4d-b4d2-df6658a297c6")
        );

        songCategoryRepository.insertSongSongCategory(
                UUID.fromString("b77433fb-2e21-4fef-abff-8e1637456c0e"),
                UUID.fromString("5e94c08b-8e9a-4f4d-b4d2-df6658a297c6")
        );

        songCategoryRepository.insertSongSongCategory(
                UUID.fromString("789bd035-b492-4b26-9588-a671fe091d16"),
                UUID.fromString("5e94c08b-8e9a-4f4d-b4d2-df6658a297c6")
        );

        // Wielkanoc
        songCategoryRepository.insertSongSongCategory(
                UUID.fromString("60c81edc-a645-4fa6-9413-e32c71ad96a7"),
                UUID.fromString("4d3819e0-d413-4b89-99e1-2679fbd2e792")
        );

        // Okres zwykły
        songCategoryRepository.insertSongSongCategory(
                UUID.fromString("1a03f4fe-a53a-435c-9a4e-fffc0819cdb0"),
                UUID.fromString("1684a118-9e33-4f45-8aeb-d3e1b51ef2be")
        );

        songCategoryRepository.insertSongSongCategory(
                UUID.fromString("af0b1fe7-6889-4314-8de1-9361b2c78e7e"),
                UUID.fromString("1684a118-9e33-4f45-8aeb-d3e1b51ef2be")
        );

        songCategoryRepository.insertSongSongCategory(
                UUID.fromString("f127ab80-84ee-4d26-a6ff-573d27b451de"),
                UUID.fromString("1684a118-9e33-4f45-8aeb-d3e1b51ef2be")
        );

        // Psalmy
        songCategoryRepository.insertSongSongCategory(
                UUID.fromString("f4bb4062-dce9-4086-b02c-7c933d8e7745"),
                UUID.fromString("a297e4a4-7a2b-4626-a9a9-1c99db749d6b")
        );
    }
}
