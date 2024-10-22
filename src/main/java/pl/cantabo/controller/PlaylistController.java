package pl.cantabo.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.*;
import pl.cantabo.database.playlist.PlaylistDAO;
import pl.cantabo.database.playlist.PlaylistInfoDTO;
import pl.cantabo.database.playlist.PlaylistMapper;
import pl.cantabo.database.playlist.PlaylistUpdateDTO;
import pl.cantabo.database.playlist.playlistCategory.PlaylistCategoryInfoDTO;
import pl.cantabo.database.playlist.playlistCategory.PlaylistCategoryMapper;
import pl.cantabo.database.song.SongInfoDTO;
import pl.cantabo.database.song.SongMapper;
import pl.cantabo.service.PlaylistService;

import javax.validation.Valid;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Log4j2
@RestController
@RequestMapping("/dashboard/playlist")
@RequiredArgsConstructor
@CrossOrigin
public class PlaylistController {

    private final PlaylistService playlistService;
    private final PlaylistMapper playlistMapper;
    private final SongMapper songMapper;
    private final PlaylistCategoryMapper playlistCategoryMapper;

    @PutMapping("{id}")
    public PlaylistInfoDTO updatePlaylist(@RequestBody @Valid PlaylistUpdateDTO playlist, @PathVariable UUID id) {
        log.debug("Update playlist {}: {}", id, playlist);
        PlaylistDAO updatedPlaylist = playlistService.update(id, playlistMapper.playlistUpdateDTO2PlaylistDAO(playlist));
        return log.traceExit(playlistMapper.playlistDAO2PlaylistInfoDTO(updatedPlaylist));
    }

    @DeleteMapping("{id}")
    public void deletePlaylist(@PathVariable UUID id) {
        log.debug("Deleting playlist {}", id);
        playlistService.delete(id);
    }

    @GetMapping
    public List<PlaylistInfoDTO> getAll(@RequestParam(required = false) UUID category) {
        if (category != null) {
            return getPlaylistsByCategory(category);
        } else {
            return getAllPlaylists();
        }
    }

    private List<PlaylistInfoDTO> getAllPlaylists() {
        log.debug("Getting all playlists");
        return log.traceExit(
                playlistService.getAll()
                        .stream()
                        .map(playlistMapper::playlistDAO2PlaylistInfoDTO)
                        .collect(Collectors.toList())
        );
    }

    private List<PlaylistInfoDTO> getPlaylistsByCategory(UUID category) {
        log.debug("Getting playlists by category: {}", category);
        return log.traceExit(
                playlistService.getAllByCategory(category)
                        .stream()
                        .map(playlistMapper::playlistDAO2PlaylistInfoDTO)
                        .collect(Collectors.toList())
        );
    }

    @GetMapping("/songsForPlaylist/{id}")
    public List<SongInfoDTO> getSongsByPlaylistId(@PathVariable UUID id) {
        log.debug("Getting all songs for playlist");
        return log.traceExit(
                playlistService.getSongsByPlaylistId(id)
                        .stream()
                        .map(songMapper::songDAO2SongInfoDTO)
                        .collect(Collectors.toList())
        );
    }

    @GetMapping("/playlistCategoriesForPlaylist/{id}")
    public List<PlaylistCategoryInfoDTO> getPlaylistCategoriesByPlaylistId(@PathVariable UUID id) {
        log.debug("Getting all playlist categories for playlist");
        return log.traceExit(
                playlistService.getPlaylistCategoriesByPlaylistId(id)
                        .stream()
                        .map(playlistCategoryMapper::playlistCategoryDAO2PlaylistCategoryInfoDTO)
                        .collect(Collectors.toList())
        );
    }
}
