package pl.cantabo.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import pl.cantabo.database.slide.SlideDAO;
import pl.cantabo.database.slide.SlideRepository;
import pl.cantabo.database.slide.factory.SlideDAOFactory;

import java.util.List;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;

class SlideServiceTest {

    private SlideService slideService;

    private SlideRepository slideRepository;

    @BeforeEach
    public void init() {
        slideRepository = Mockito.mock(SlideRepository.class);
        slideService = new SlideService(slideRepository);
    }

    @Test
    void create() {
        // given
        SlideDAO slide = SlideDAOFactory.defaultBuilder().build();

        // when
        slideService.create(slide);

        // then
        verify(slideRepository, times(1)).save(slide);
        assertNotNull(slide);
    }

    @Test
    void delete() {
        // given
        UUID id = UUID.randomUUID();

        // when
        slideService.delete(id);

        // then
        verify(slideRepository, times(1)).deleteById(id);
    }

    @Test
    void getAll() {
        // given
        List<SlideDAO> slideList = List.of(
                SlideDAOFactory.defaultBuilder().build(),
                SlideDAOFactory.defaultBuilder().build(),
                SlideDAOFactory.defaultBuilder().build()
        );
        when(slideRepository.findAll()).thenReturn(slideList);

        // when
        List<SlideDAO> slideDAOList = slideService.getAll();

        // then
        verify(slideRepository, times(1)).findAll();
        assertEquals(3, slideDAOList.size());
    }
}
