package pl.cantabo.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import pl.cantabo.database.song.songCategory.SongCategoryDAO;
import pl.cantabo.database.song.songCategory.SongCategoryRepository;
import pl.cantabo.database.song.songCategory.factory.SongCategoryDAOFactory;
import pl.cantabo.validator.SongCategoryValidator;

import java.util.List;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;

class SongCategoryServiceTest {

    private SongCategoryService songCategoryService;

    private SongCategoryRepository songCategoryRepository;

    @BeforeEach
    public void init() {
        songCategoryRepository = Mockito.mock(SongCategoryRepository.class);
        songCategoryService = new SongCategoryService(songCategoryRepository, new SongCategoryValidator(songCategoryRepository));
    }

    @Test
    void create() {
        // given
        SongCategoryDAO songCategory = SongCategoryDAOFactory.defaultBuilder().build();

        // when
        songCategoryService.create(songCategory);

        // then
        verify(songCategoryRepository, times(1)).save(songCategory);
        assertNotNull(songCategory);
    }

    @Test
    void delete() {
        // given
        UUID id = UUID.randomUUID();

        // when
        songCategoryService.delete(id);

        // then
        verify(songCategoryRepository, times(1)).deleteById(id);
    }

    @Test
    void getAll() {
        // given
        List<SongCategoryDAO> songCategoryList = List.of(
                SongCategoryDAOFactory.defaultBuilder().build(),
                SongCategoryDAOFactory.defaultBuilder().build(),
                SongCategoryDAOFactory.defaultBuilder().build()
        );

        when(songCategoryRepository.findAll()).thenReturn(songCategoryList);

        // when
        List<SongCategoryDAO> result = songCategoryService.getAll();

        // then
        verify(songCategoryRepository, times(1)).findAll();
        assertEquals(songCategoryList, result);
    }
}