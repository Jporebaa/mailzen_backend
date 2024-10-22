package pl.cantabo.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.cantabo.service.StatisticsService;

@Log4j2
@RestController
@RequestMapping("/dashboard/app")
@RequiredArgsConstructor
@CrossOrigin
public class DashboardController {

    private final StatisticsService statisticsService;

    @GetMapping("/users")
    public int getNumberOfUsers() {
        log.debug("Getting number of users");
        return log.traceExit(statisticsService.getNumberOfUsers());
    }

    @GetMapping("/groups")
    public int getNumberOfGroups() {
        log.debug("Getting number of groups");
        return log.traceExit(statisticsService.getNumberOfGroups());
    }

    @GetMapping("/songs")
    public int getNumberOfSongs() {
        log.debug("Getting number of songs");
        return log.traceExit(statisticsService.getNumberOfSongs());
    }

    @GetMapping("/playlists")
    public int getNumberOfPlaylist() {
        log.debug("Getting number of playlist");
        return log.traceExit(statisticsService.getNumberOfPlaylist());
    }
}
