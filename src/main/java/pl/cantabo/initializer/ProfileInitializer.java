package pl.cantabo.initializer;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import pl.cantabo.database.profile.ProfileRepository;

import java.util.UUID;

@Component
@RequiredArgsConstructor
public class ProfileInitializer {

    private final ProfileRepository profileRepository;

    public void initialize() {
        profileRepository.insertProfile(
                UUID.fromString("4971c362-55bc-48b8-a80a-e862bf5595fb"),
                "Domyślny",
                true,
                "CENTER",
                false,
                false,
                false,
                1,
                20,
                7,
                true,
                false,
                false,
                "#000000",
                "#000000",
                "#ffffff",
                true
        );
    }
}
