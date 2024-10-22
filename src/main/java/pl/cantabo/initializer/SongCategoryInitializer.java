package pl.cantabo.initializer;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import pl.cantabo.database.song.songCategory.SongCategoryRepository;

import java.util.UUID;

@Component
@RequiredArgsConstructor
public class SongCategoryInitializer {

    private final SongCategoryRepository songCategoryRepository;

    public void initialize() {
        songCategoryRepository.insertSongCategory(
                UUID.fromString("f2cbf45e-54b7-4e56-8a94-d1b118f810d0"),
                "Adwent",
                true
        );

        songCategoryRepository.insertSongCategory(
                UUID.fromString("6700b4e7-13f0-45c4-b63b-44d446a45a3f"),
                "Boże Narodzenie",
                true
        );

        songCategoryRepository.insertSongCategory(
                UUID.fromString("5e94c08b-8e9a-4f4d-b4d2-df6658a297c6"),
                "Wielki Post",
                true
        );

        songCategoryRepository.insertSongCategory(
                UUID.fromString("4d3819e0-d413-4b89-99e1-2679fbd2e792"),
                "Wielkanoc",
                true
        );

        songCategoryRepository.insertSongCategory(
                UUID.fromString("1684a118-9e33-4f45-8aeb-d3e1b51ef2be"),
                "Okres zwykły",
                true
        );

        songCategoryRepository.insertSongCategory(
                UUID.fromString("a297e4a4-7a2b-4626-a9a9-1c99db749d6b"),
                "Psalmy",
                true
        );
    }
}
