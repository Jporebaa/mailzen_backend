package pl.cantabo.initializer;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import pl.cantabo.database.user.UserRepository;

import java.util.UUID;

@Component
@RequiredArgsConstructor
public class UserInitializer {

    private final UserRepository userRepository;

    public void initialize() {
        // hasło: qwQW12!@12
        userRepository.insertUser(
                UUID.fromString("b7e2180c-459b-444d-a47a-703cf9ba5ae8"),
                true,
                "superadmin@cantabo.pl",
                "Super admin",
                "$2a$10$ZavydPLj7og39pWGFIKc0erCzLgGdxontrcwQ5c492ZcpcjwZa2W6",
                "SUPER_ADMINISTRATOR",
                true
        );

        userRepository.insertUser(
                UUID.fromString("1b7c849c-a3e5-4b9d-a868-3c64416f04bf"),
                true,
                "admin@cantabo.pl",
                "Admin",
                "$2a$10$ZavydPLj7og39pWGFIKc0erCzLgGdxontrcwQ5c492ZcpcjwZa2W6",
                "ADMINISTRATOR",
                true
        );

        userRepository.insertUser(
                UUID.fromString("feaf1c67-7241-4086-8f1c-a7a60b05af84"),
                true,
                "user@cantabo.pl",
                "User",
                "$2a$10$ZavydPLj7og39pWGFIKc0erCzLgGdxontrcwQ5c492ZcpcjwZa2W6",
                "USER",
                true
        );

        userRepository.insertUser(
                UUID.fromString("aabd811e-97b5-4ed9-9650-242a30b2f119"),
                true,
                "szymonpogwizd12@gmail.com",
                "Szymon Pogwizd",
                "$2a$10$ZavydPLj7og39pWGFIKc0erCzLgGdxontrcwQ5c492ZcpcjwZa2W6",
                "SUPER_ADMINISTRATOR",
                true
        );

        userRepository.insertUser(
                UUID.fromString("4011b8d0-f4d3-42dd-a4be-b2e0dff0f219"),
                true,
                "jakubporeba8@gmail.com",
                "Jakub Poręba",
                "$2a$10$ZavydPLj7og39pWGFIKc0erCzLgGdxontrcwQ5c492ZcpcjwZa2W6",
                "SUPER_ADMINISTRATOR",
                true
        );
    }
}
