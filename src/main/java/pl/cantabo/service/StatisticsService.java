package pl.cantabo.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;
import pl.cantabo.database.group.GroupRepository;
import pl.cantabo.database.playlist.PlaylistRepository;
import pl.cantabo.database.song.SongRepository;
import pl.cantabo.database.user.UserRepository;

@Service
@Log4j2
@RequiredArgsConstructor
public class StatisticsService {

    private final UserRepository userRepository;
    private final GroupRepository groupRepository;
    private final SongRepository songRepository;
    private final PlaylistRepository playlistRepository;

    public int getNumberOfUsers() {
        log.debug("Getting number of users");
        return log.traceExit(userRepository.countUsers());
    }

    public int getNumberOfGroups() {
        log.debug("Getting number of groups");
        return log.traceExit(groupRepository.countGroups());
    }

    public int getNumberOfSongs() {
        log.debug("Getting number of songs");
        return log.traceExit(songRepository.countSongs());
    }

    public int getNumberOfPlaylist() {
        log.debug("Getting number of playlist");
        return log.traceExit(playlistRepository.countPlaylists());
    }
}
