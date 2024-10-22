package pl.cantabo.database.slide;

import jakarta.transaction.Transactional;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import pl.cantabo.database.slide.factory.SlideDAOFactory;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
@Transactional
public class SlideRepositoryTest {

    @Autowired
    private SlideRepository slideRepository;

    @BeforeEach
    public void setUp() {
        slideRepository.deleteAll();
    }

    @Test
    public void saveSlideTest() {
        // given
        SlideDAO slideDAO = SlideDAOFactory.defaultBuilder().build();

        // when
        SlideDAO savedSlideDAO = slideRepository.saveAndFlush(slideDAO);

        // then
        assertNotNull(savedSlideDAO.getId());
        assertEquals(slideDAO, savedSlideDAO);
    }

    @Test
    public void updateSlideTest() {
        // given
        SlideDAO slideDAO = SlideDAOFactory.defaultBuilder().build();

        // when
        slideRepository.saveAndFlush(slideDAO);
        slideDAO.setBody("newBody");
        SlideDAO savedSlideDAO = slideRepository.saveAndFlush(slideDAO);

        // then
        assertNotNull(savedSlideDAO);
        assertEquals(slideDAO.getId(), savedSlideDAO.getId());
        assertEquals("newBody", savedSlideDAO.getBody());
    }

    @Test
    public void findSlideTest() {
        // given
        SlideDAO slideDAO1 = SlideDAOFactory.defaultBuilder().build();
        SlideDAO slideDAO2 = SlideDAOFactory.defaultBuilder().build();
        slideRepository.saveAndFlush(slideDAO1);
        slideRepository.saveAndFlush(slideDAO2);

        // when
        List<SlideDAO> allSlides = slideRepository.findAll();

        // then
        assertEquals(2, allSlides.size());
    }
}
