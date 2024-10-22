package pl.cantabo.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.*;
import pl.cantabo.database.profile.*;
import pl.cantabo.service.ProfileService;

import javax.validation.Valid;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Log4j2
@RestController
@RequestMapping("/dashboard/profiles")
@RequiredArgsConstructor
@CrossOrigin
public class ProfileController {

    private final ProfileService profileService;
    private final ProfileMapper profileMapper;

    @PostMapping
    public ProfileInfoDTO createProfile(@RequestBody @Valid ProfileCreateDTO profile) {
        log.debug("Create profile {}", profile);
        ProfileDAO toCreate = profileMapper.profileCreateDTO2ProfileDAO(profile);
        ProfileDAO createdProfile = profileService.create(toCreate);
        return log.traceExit(profileMapper.profileDAO2ProfileInfoDTO(createdProfile));
    }

    @PutMapping("{id}")
    public ProfileInfoDTO updateProfile(@RequestBody @Valid ProfileUpdateDTO profile, @PathVariable UUID id) {
        log.debug("Update profile {}: {}", id, profile);
        ProfileDAO updatedProfile = profileService.update(id, profileMapper.profileUpdateDTO2ProfileDAO(profile));
        return log.traceExit(profileMapper.profileDAO2ProfileInfoDTO(updatedProfile));
    }

    @GetMapping
    public List<ProfileInfoDTO> getAll() {
        log.debug("Getting all profiles");
        return log.traceExit(
                profileService.getAll()
                        .stream()
                        .map(profileMapper::profileDAO2ProfileInfoDTO)
                        .collect(Collectors.toList())
        );
    }

    @DeleteMapping("{id}")
    public void deleteProfile(@PathVariable UUID id) {
        log.debug("Deleting profile {}", id);
        profileService.delete(id);
    }
}
