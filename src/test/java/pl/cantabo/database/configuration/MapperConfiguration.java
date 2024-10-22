package pl.cantabo.database.configuration;

import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import pl.cantabo.database.group.GroupMapper;
import pl.cantabo.database.group.GroupMapperImpl;
import pl.cantabo.database.playlist.PlaylistMapper;
import pl.cantabo.database.playlist.PlaylistMapperImpl;
import pl.cantabo.database.playlist.playlistCategory.PlaylistCategoryMapper;
import pl.cantabo.database.playlist.playlistCategory.PlaylistCategoryMapperImpl;
import pl.cantabo.database.profile.ProfileMapper;
import pl.cantabo.database.profile.ProfileMapperImpl;
import pl.cantabo.database.settings.SettingsMapper;
import pl.cantabo.database.settings.SettingsMapperImpl;
import pl.cantabo.database.slide.SlideMapper;
import pl.cantabo.database.slide.SlideMapperImpl;
import pl.cantabo.database.song.SongMapper;
import pl.cantabo.database.song.SongMapperImpl;
import pl.cantabo.database.song.songCategory.SongCategoryMapper;
import pl.cantabo.database.song.songCategory.SongCategoryMapperImpl;
import pl.cantabo.database.user.UserMapper;
import pl.cantabo.database.user.UserMapperImpl;
import pl.cantabo.utils.password.PasswordEncoderMapper;

@TestConfiguration
public class MapperConfiguration {

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public PasswordEncoderMapper passwordEncoderMapper(PasswordEncoder passwordEncoder) {
        return new PasswordEncoderMapper(passwordEncoder);
    }

    @Bean
    public UserMapper userMapper() {
        return new UserMapperImpl();
    }

    @Bean
    public SongMapper songMapper() {
        return new SongMapperImpl();
    }

    @Bean
    public SongCategoryMapper songCategoryMapper() {
        return new SongCategoryMapperImpl();
    }

    @Bean
    public ProfileMapper profileMapper() {
        return new ProfileMapperImpl();
    }

    @Bean
    public SettingsMapper settingsMapper() {
        return new SettingsMapperImpl();
    }

    @Bean
    public GroupMapper groupMapper() {
        return new GroupMapperImpl();
    }

    @Bean
    public SlideMapper slideMapper() {
        return new SlideMapperImpl();
    }

    @Bean
    public PlaylistMapper playlistMapper() {
        return new PlaylistMapperImpl();
    }

    @Bean
    public PlaylistCategoryMapper playlistCategoryMapper() {
        return new PlaylistCategoryMapperImpl();
    }
}