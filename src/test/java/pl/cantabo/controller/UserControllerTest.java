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
import pl.cantabo.database.group.GroupDAO;
import pl.cantabo.database.group.factory.GroupDAOFactory;
import pl.cantabo.database.user.UserCreateDTO;
import pl.cantabo.database.user.UserDAO;
import pl.cantabo.database.user.UserType;
import pl.cantabo.database.user.factory.UserDAOFactory;
import pl.cantabo.database.user.factory.UserDTOFactory;
import pl.cantabo.service.*;
import pl.cantabo.utils.JsonUtility;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.hasSize;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.csrf;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ContextConfiguration(classes = MapperConfiguration.class)
@RunWith(SpringRunner.class)
@WebMvcTest(UserController.class)
@WithMockUser(username = "user", roles = "USER")
class UserControllerTest {

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

    @Test
    public void createUser_ok() throws Exception {
        // given
        UserDAO userDAO = UserDAOFactory.defaultBuilder().build();
        UserCreateDTO createDTO = UserDTOFactory.defaultUserCreateDTO();
        given(userService.create(any())).willReturn(userDAO);

        // when
        // then
        mockMvc.perform(post("/dashboard/users").with(csrf())
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(JsonUtility.toJson(createDTO)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.email", is(userDAO.getEmail())))
                .andExpect(jsonPath("$.name", is(userDAO.getName())))
                .andExpect(jsonPath("$.userType", is(userDAO.getUserType().toString())))
                .andExpect(jsonPath("$.active", is(userDAO.getActive())));
    }

    @Test
    public void createUser_noValidInput() throws Exception {
        // given
        UserCreateDTO createDTO = UserDTOFactory.defaultUserCreateDTO();
        createDTO.setEmail(null);

        // when
        // then
        mockMvc.perform(post("/dashboard/users").with(csrf())
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(JsonUtility.toJson(createDTO)))
                .andExpect(status().isOk());
    }

    @Test
    public void getAll() throws Exception {
        // given
        List<UserDAO> givenUsers = UserDAOFactory.defaultList();
        given(userService.getAll()).willReturn(givenUsers);

        // when
        // then
        mockMvc.perform(get("/dashboard/users").with(csrf()))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.size()", is(givenUsers.size())));
    }

    @Test
    public void getUserType() throws Exception {
        // given
        List<UserType> userTypes = Arrays.asList(UserType.values());
        when(userService.getAllUserTypes()).thenReturn(userTypes);

        // when
        mockMvc.perform(get("/dashboard/users/userTypes").with(csrf()))

                // then
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(userTypes.size())))
                .andExpect(jsonPath("$[0]").value(UserType.USER.toString()))
                .andExpect(jsonPath("$[1]").value(UserType.ADMINISTRATOR.toString()))
                .andExpect(jsonPath("$[2]").value(UserType.SUPER_ADMINISTRATOR.toString()));
    }

    @Test
    public void getGroup() throws Exception {
        // given
        List<GroupDAO> givenGroups = GroupDAOFactory.defaultList();
        given(groupService.getAll()).willReturn(givenGroups);

        // when
        // then
        mockMvc.perform(get("/dashboard/users/groups").with(csrf()))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.size()", is(givenGroups.size())));
    }

    @Test
    public void deleteUser() throws Exception {
        // given
        doNothing().when(userService).delete(any());

        // when
        // then
        mockMvc.perform(delete("/dashboard/users/" + UUID.randomUUID()).with(csrf()))
                .andExpect(status().isOk());
    }
}