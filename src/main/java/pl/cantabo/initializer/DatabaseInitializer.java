package pl.cantabo.initializer;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@RequiredArgsConstructor
public class DatabaseInitializer implements CommandLineRunner {

    private final SongInitializer songInitializer;
    private final SlideInitializer slideInitializer;
    private final SongCategoryInitializer songCategoryInitializer;
    private final SongSongCategoryInitializer songSongCategoryInitializer;
    private final PlaylistInitializer playlistInitializer;
    private final PlaylistCategoryInitializer playlistCategoryInitializer;
    private final PlaylistPlaylistCategoryInitializer playlistPlaylistCategoryInitializer;
    private final ProfileInitializer profileInitializer;
    private final PlaylistSongInitializer playlistSongInitializer;
    private final UserInitializer userInitializer;

    @Override
    @Transactional
    public void run(String... args) throws Exception {
        userInitializer.initialize();
        songInitializer.initialize();
        slideInitializer.initialize();
        songCategoryInitializer.initialize();
        songSongCategoryInitializer.initialize();
        playlistInitializer.initialize();
        playlistCategoryInitializer.initialize();
        playlistPlaylistCategoryInitializer.initialize();
        playlistSongInitializer.initialize();
        profileInitializer.initialize();
    }
}
