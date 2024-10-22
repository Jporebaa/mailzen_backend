package pl.cantabo.controller;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import pl.cantabo.database.configuration.MapperConfiguration;
import pl.cantabo.database.slide.SlideDAO;
import pl.cantabo.database.slide.factory.SlideDAOFactory;
import pl.cantabo.database.song.SongCreateDTO;
import pl.cantabo.database.song.SongDAO;
import pl.cantabo.database.song.factory.SongDAOFactory;
import pl.cantabo.database.song.factory.SongDTOFactory;
import pl.cantabo.service.*;
import pl.cantabo.utils.JsonUtility;

import static org.hamcrest.CoreMatchers.is;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.csrf;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ContextConfiguration(classes = MapperConfiguration.class)
@RunWith(SpringRunner.class)
@WebMvcTest(SongManagerController.class)
@WithMockUser(username = "user", roles = "USER")
public class SongManagerControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private UserService userService;

    @MockBean
    private SongService songService;

    @MockBean
    private SongCategoryService songCategoryService;

    @MockBean
    private ProfileService profileService;

    @MockBean
    private GroupService groupService;

    @MockBean
    private PlaylistCategoryService playlistCategoryService;

    @MockBean
    private SlideService slideService;



    @Test
    public void createSong() throws Exception {
        // given
        SongDAO songDAO = SongDAOFactory.defaultBuilder().build();
        SlideDAO slideDAO = SlideDAOFactory.defaultBuilder().build();
        SongCreateDTO createDTO = SongDTOFactory.defaultSongCreateDTO();
        given(songService.create(any())).willReturn(songDAO);
        given(slideService.create(any())).willReturn(slideDAO);

        // when
        // then
        mockMvc.perform(post("/dashboard/songManager").with(csrf())
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(JsonUtility.toJson(createDTO)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name", is(songDAO.getName())))
                .andExpect(jsonPath("$.musicAuthor", is(songDAO.getMusicAuthor())))
                .andExpect(jsonPath("$.wordsAuthor", is(songDAO.getWordsAuthor())));
    }
}
