package pl.cantabo.database.settings;

import jakarta.transaction.Transactional;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import pl.cantabo.database.settings.factory.SettingsDAOFactory;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
@Transactional
public class SettingsRepositoryTest {

    @Autowired
    private SettingsRepository settingsRepository;

    @BeforeEach
    public void setUp() {
        settingsRepository.deleteAll();
    }

    @Test
    public void saveSettingsTest() {
        // given
        SettingsDAO settingsDAO = SettingsDAOFactory.defaultBuilder().build();

        // when
        SettingsDAO savedSettingsDAO = settingsRepository.saveAndFlush(settingsDAO);

        // then
        assertNotNull(savedSettingsDAO.getId());
        assertEquals(settingsDAO, savedSettingsDAO);
    }
}
