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
import pl.cantabo.database.profile.ProfileCreateDTO;
import pl.cantabo.database.profile.ProfileDAO;
import pl.cantabo.database.profile.factory.ProfileDAOFactory;
import pl.cantabo.database.profile.factory.ProfileDTOFactory;
import pl.cantabo.service.ProfileService;
import pl.cantabo.utils.JsonUtility;

import java.util.List;
import java.util.UUID;

import static org.hamcrest.CoreMatchers.is;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.doNothing;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.csrf;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ContextConfiguration(classes = MapperConfiguration.class)
@RunWith(SpringRunner.class)
@WebMvcTest(ProfileController.class)
@WithMockUser(username = "user", roles = "USER")
class ProfileControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ProfileService profileService;

    @Test
    public void createProfile() throws Exception {
        // given
        ProfileDAO profileDAO = ProfileDAOFactory.defaultBuilder().build();
        ProfileCreateDTO createDTO = ProfileDTOFactory.defaultProfileCreateDTO();
        given(profileService.create(any())).willReturn(profileDAO);

        // when
        // then
        mockMvc.perform(post("/dashboard/profiles").with(csrf())
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(JsonUtility.toJson(createDTO)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name", is(profileDAO.getName())))
                .andExpect(jsonPath("$.active", is(profileDAO.isActive())))
                .andExpect(jsonPath("$.sortByUsed", is(profileDAO.isSortByUsed())))
                .andExpect(jsonPath("$.bgColor", is(profileDAO.getBgColor())))
                .andExpect(jsonPath("$.txColor", is(profileDAO.getTxColor())))
                .andExpect(jsonPath("$.stopColor", is(profileDAO.getStopColor())))
                .andExpect(jsonPath("$.fontStyle", is(profileDAO.getFontStyle())))
                .andExpect(jsonPath("$.margin", is(profileDAO.getMargin())))
                .andExpect(jsonPath("$.maxFont", is(profileDAO.getMaxFont())))
                .andExpect(jsonPath("$.maxMin", is(profileDAO.getMaxMin())))
                .andExpect(jsonPath("$.align", is(profileDAO.getAlign())))
                .andExpect(jsonPath("$.algorithmRange", is(profileDAO.getAlgorithmRange())))
                .andExpect(jsonPath("$.showTitle", is(profileDAO.isShowTitle())))
                .andExpect(jsonPath("$.allBig", is(profileDAO.isAllBig())))
                .andExpect(jsonPath("$.showEmptySlide", is(profileDAO.isShowEmptySlide())))
                .andExpect(jsonPath("$.invertColors", is(profileDAO.isInvertColors())))
                .andExpect(jsonPath("$.expandedList", is(profileDAO.isExpandedList())));
    }

    @Test
    public void getAll() throws Exception {
        // given
        List<ProfileDAO> givenProfiles = ProfileDAOFactory.defaultList();
        given(profileService.getAll()).willReturn(givenProfiles);

        // when
        // then
        mockMvc.perform(get("/dashboard/profiles").with(csrf()))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.size()", is(givenProfiles.size())));
    }

    @Test
    public void deleteUser() throws Exception {
        // given
        doNothing().when(profileService).delete(any());

        // when
        // then
        mockMvc.perform(delete("/dashboard/profiles/" + UUID.randomUUID()).with(csrf()))
                .andExpect(status().isOk());
    }
}