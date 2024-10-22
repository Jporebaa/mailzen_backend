package pl.cantabo.database.profile.factory;

import pl.cantabo.database.profile.ProfileCreateDTO;
import pl.cantabo.database.profile.ProfileUpdateDTO;

public class ProfileDTOFactory {

    public static ProfileCreateDTO defaultProfileCreateDTO() {
        ProfileCreateDTO profileCreateDTO = new ProfileCreateDTO();
        profileCreateDTO.setName(ProfileDAOFactory.NAME);
        profileCreateDTO.setActive(ProfileDAOFactory.ACTIVE);
        profileCreateDTO.setSortByUsed(ProfileDAOFactory.SORT_BY_USED);
        profileCreateDTO.setBgColor(ProfileDAOFactory.BG_COLOR);
        profileCreateDTO.setTxColor(ProfileDAOFactory.TX_COLOR);
        profileCreateDTO.setStopColor(ProfileDAOFactory.STOP_COLOR);
        profileCreateDTO.setFontStyle(ProfileDAOFactory.FONT_STYLE);
        profileCreateDTO.setMargin(ProfileDAOFactory.MARGIN);
        profileCreateDTO.setMaxFont(ProfileDAOFactory.MAX_FONT);
        profileCreateDTO.setMaxMin(ProfileDAOFactory.MAX_MIN);
        profileCreateDTO.setAlign(ProfileDAOFactory.ALIGN);
        profileCreateDTO.setAlgorithmRange(ProfileDAOFactory.ALGORITHM_RANGE);
        profileCreateDTO.setShowTitle(ProfileDAOFactory.SHOW_TITLE);
        profileCreateDTO.setAllBig(ProfileDAOFactory.ALL_BIG);
        profileCreateDTO.setShowEmptySlide(ProfileDAOFactory.SHOW_EMPTY_SLIDE);
        profileCreateDTO.setInvertColors(ProfileDAOFactory.INVERT_COLORS);
        profileCreateDTO.setExpandedList(ProfileDAOFactory.EXPANDED_LIST);
        return profileCreateDTO;
    }

    public static ProfileUpdateDTO defaultProfileUpdateDTO() {
        ProfileUpdateDTO profileUpdateDTO = new ProfileUpdateDTO();
        profileUpdateDTO.setName(ProfileDAOFactory.NAME);
        profileUpdateDTO.setActive(ProfileDAOFactory.ACTIVE);
        profileUpdateDTO.setSortByUsed(ProfileDAOFactory.SORT_BY_USED);
        profileUpdateDTO.setBgColor(ProfileDAOFactory.BG_COLOR);
        profileUpdateDTO.setTxColor(ProfileDAOFactory.TX_COLOR);
        profileUpdateDTO.setStopColor(ProfileDAOFactory.STOP_COLOR);
        profileUpdateDTO.setFontStyle(ProfileDAOFactory.FONT_STYLE);
        profileUpdateDTO.setMargin(ProfileDAOFactory.MARGIN);
        profileUpdateDTO.setMaxFont(ProfileDAOFactory.MAX_FONT);
        profileUpdateDTO.setMaxMin(ProfileDAOFactory.MAX_MIN);
        profileUpdateDTO.setAlign(ProfileDAOFactory.ALIGN);
        profileUpdateDTO.setAlgorithmRange(ProfileDAOFactory.ALGORITHM_RANGE);
        profileUpdateDTO.setShowTitle(ProfileDAOFactory.SHOW_TITLE);
        profileUpdateDTO.setAllBig(ProfileDAOFactory.ALL_BIG);
        profileUpdateDTO.setShowEmptySlide(ProfileDAOFactory.SHOW_EMPTY_SLIDE);
        profileUpdateDTO.setInvertColors(ProfileDAOFactory.INVERT_COLORS);
        profileUpdateDTO.setExpandedList(ProfileDAOFactory.EXPANDED_LIST);
        return profileUpdateDTO;
    }
}
