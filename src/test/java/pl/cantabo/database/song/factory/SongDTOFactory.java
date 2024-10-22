package pl.cantabo.database.song.factory;

import pl.cantabo.database.song.SongCreateDTO;
import pl.cantabo.database.song.SongUpdateDTO;

public class SongDTOFactory {

    public static SongCreateDTO defaultSongCreateDTO() {
        SongCreateDTO songCreateDTO = new SongCreateDTO();
        songCreateDTO.setName(SongDAOFactory.NAME);
        songCreateDTO.setMusicAuthor(SongDAOFactory.MUSIC_AUTHOR);
        songCreateDTO.setWordsAuthor(SongDAOFactory.WORDS_AUTHOR);
        return songCreateDTO;
    }

    public static SongUpdateDTO defaultSongUpdateDTO() {
        SongUpdateDTO songUpdateDTO = new SongUpdateDTO();
        songUpdateDTO.setName(SongDAOFactory.NAME);
        songUpdateDTO.setMusicAuthor(SongDAOFactory.MUSIC_AUTHOR);
        songUpdateDTO.setWordsAuthor(SongDAOFactory.WORDS_AUTHOR);
        return songUpdateDTO;
    }
}
