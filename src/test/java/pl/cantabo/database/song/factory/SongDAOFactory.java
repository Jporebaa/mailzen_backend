package pl.cantabo.database.song.factory;

import pl.cantabo.database.song.SongDAO;

import java.util.List;

public class SongDAOFactory {

    public static final String NAME = "testName";
    public static final String MUSIC_AUTHOR = "musicAuthor";
    public static final String WORDS_AUTHOR = "wordsAuthor";
    public static final long VIEW_COUNTER = 0L;
    public static final boolean DEFAULT_ITEM = false;

    public static SongDAO.SongDAOBuilder defaultBuilder() {
        return SongDAO.builder()
                .name(NAME)
                .musicAuthor(MUSIC_AUTHOR)
                .wordsAuthor(WORDS_AUTHOR)
                .viewCounter(VIEW_COUNTER)
                .defaultItem(DEFAULT_ITEM)
                .parentId(null)
                .songCategories(null)
                .slides(null)
                .songHistory(null);
    }

    public static List<SongDAO> defaultList() {
        return List.of(
                defaultBuilder().name("testName1").build(),
                defaultBuilder().name("testName2").build()
        );
    }
}
