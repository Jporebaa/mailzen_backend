package pl.cantabo.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.*;
import pl.cantabo.database.playlist.PlaylistCreateDTO;
import pl.cantabo.database.playlist.PlaylistDAO;
import pl.cantabo.database.playlist.PlaylistInfoDTO;
import pl.cantabo.database.playlist.PlaylistMapper;
import pl.cantabo.service.PlaylistService;

import javax.validation.Valid;

@Log4j2
@RestController
@RequestMapping("/dashboard/playlistCreate")
@RequiredArgsConstructor
@CrossOrigin
public class PlaylistCreateController {

    private final PlaylistService playlistService;
    private final PlaylistMapper playlistMapper;

    @PostMapping
    public PlaylistInfoDTO createPlaylist(@RequestBody @Valid PlaylistCreateDTO playlist) {
        log.debug("Create playlist {}", playlist);
        PlaylistDAO toCreate = playlistMapper.playlistCreateDTO2PlaylistDAO(playlist);
        PlaylistDAO createdPlaylist = playlistService.create(toCreate);
        return log.traceExit(playlistMapper.playlistDAO2PlaylistInfoDTO(createdPlaylist));
    }
}
