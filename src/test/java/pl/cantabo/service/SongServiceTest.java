package pl.cantabo.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import pl.cantabo.database.song.SongDAO;
import pl.cantabo.database.song.SongRepository;
import pl.cantabo.database.song.factory.SongDAOFactory;
import pl.cantabo.validator.SongValidator;

import java.util.List;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;

class SongServiceTest {

    private SongService songService;

    private SongRepository songRepository;

    @BeforeEach
    public void init() {
        songRepository = Mockito.mock(SongRepository.class);
        songService = new SongService(songRepository, null,null,new SongValidator(songRepository));
    }

    @Test
    void create() {
        // given
        SongDAO song = SongDAOFactory.defaultBuilder().build();

        // when
        songService.create(song);

        // then
        verify(songRepository, times(1)).save(song);
        assertNotNull(song);
    }

    @Test
    void delete() {
        // given
        UUID id = UUID.randomUUID();

        // when
        songService.delete(id);

        // then
        verify(songRepository, times(1)).deleteById(id);
    }

    @Test
    void getAll() {
        // given
        List<SongDAO> songList = List.of(
                SongDAOFactory.defaultBuilder().build(),
                SongDAOFactory.defaultBuilder().build(),
                SongDAOFactory.defaultBuilder().build()
        );

        when(songRepository.findAll()).thenReturn(songList);

        // when
        List<SongDAO> songDAOList = songService.getAll();

        // then
        verify(songRepository, times(1)).findAll();
        assertEquals(3, songDAOList.size());
    }
}