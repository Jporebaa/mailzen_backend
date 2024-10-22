package pl.cantabo.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.cantabo.database.playlist.PlaylistDAO;
import pl.cantabo.database.playlist.PlaylistRepository;
import pl.cantabo.database.playlist.playlistCategory.PlaylistCategoryDAO;
import pl.cantabo.database.playlist.playlistCategory.PlaylistCategoryRepository;
import pl.cantabo.database.song.SongDAO;
import pl.cantabo.database.song.SongRepository;
import pl.cantabo.validator.PlaylistValidator;

import javax.validation.ValidationException;
import java.util.List;
import java.util.UUID;

@Service
@Log4j2
@RequiredArgsConstructor
public class PlaylistService {

    private final PlaylistRepository playlistRepository;
    private final SongRepository songRepository;
    private final PlaylistCategoryRepository playlistCategoryRepository;
    private final PlaylistValidator playlistValidator;

    @Transactional
    public PlaylistDAO create(PlaylistDAO playlist){
        log.debug("Creating playlist{}", playlist);
        playlistValidator.validatePlaylist(playlist, false);
        return log.traceExit(playlistRepository.save(playlist));
    }

    @Transactional
    public PlaylistDAO update(UUID id, PlaylistDAO playlist) {
        log.debug("Updating playlist {}: {}", id, playlist);
        boolean isSamePlaylist = playlistValidator.checkIfSamePlaylist(id, playlist);
        playlistValidator.validatePlaylist(playlist, isSamePlaylist);
        PlaylistDAO toUpdate = playlistRepository.findById(id).orElseThrow(() -> new ValidationException("Playlist o podanym id nie istnieje"));
        toUpdate.setName(playlist.getName());
        toUpdate.setPlaylistCategories(playlist.getPlaylistCategories());
        toUpdate.setSongs(playlist.getSongs());
        return log.traceExit(playlistRepository.save(toUpdate));
    }

    public void delete(UUID id){
        log.debug("Deleting playlist{}", id);
        playlistRepository.deleteById(id);
    }

    public List<PlaylistDAO> getAll(){
        log.debug("Getting all playlists");
        return log.traceExit(playlistRepository.findAll());
    }

    public List<PlaylistDAO> getAllByCategory(UUID category) {
        log.debug("Getting all playlists by category: {}", category);
        return log.traceExit(playlistRepository.findPlaylistsByCategoryId(category));
    }

    public List<SongDAO> getSongsByPlaylistId(UUID id) {
        log.debug("Getting all songs for playlist");
        return log.traceExit(songRepository.findSongsByPlaylistId(id));
    }

    public List<PlaylistCategoryDAO> getPlaylistCategoriesByPlaylistId(UUID id) {
        log.debug("Getting all playlist categories for playlist");
        return log.traceExit(playlistCategoryRepository.findPlaylistCategoriesByPlaylistId(id));
    }
}
