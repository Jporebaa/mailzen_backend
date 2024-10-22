package pl.cantabo.database.song.songCategory.factory;

import pl.cantabo.database.song.songCategory.SongCategoryCreateDTO;
import pl.cantabo.database.song.songCategory.SongCategoryUpdateDTO;

public class SongCategoryDTOFactory {

    public static SongCategoryCreateDTO defaultSongCategoryCreateDTO() {
        SongCategoryCreateDTO songCategoryCreateDTO = new SongCategoryCreateDTO();
        songCategoryCreateDTO.setName(SongCategoryDAOFactory.NAME);
        return songCategoryCreateDTO;
    }

    public static SongCategoryUpdateDTO defaultSongCategoryUpdateDTO() {
        SongCategoryUpdateDTO songCategoryUpdateDTO = new SongCategoryUpdateDTO();
        songCategoryUpdateDTO.setName(SongCategoryDAOFactory.NAME);
        return songCategoryUpdateDTO;
    }
}
