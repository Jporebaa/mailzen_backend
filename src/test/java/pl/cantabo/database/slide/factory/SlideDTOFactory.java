package pl.cantabo.database.slide.factory;

import pl.cantabo.database.slide.SlideCreateDTO;
import pl.cantabo.database.slide.SlideUpdateDTO;

public class SlideDTOFactory {

    public static SlideCreateDTO defaultSLideCreateDTO() {
        SlideCreateDTO slideCreateDTO = new SlideCreateDTO();
        slideCreateDTO.setBody(SlideDAOFactory.BODY);
        slideCreateDTO.setItemOrder(SlideDAOFactory.ORDER);

        return slideCreateDTO;
    }

    public static SlideUpdateDTO defaultSlideUpdateDTO() {
        SlideUpdateDTO slideUpdateDTO = new SlideUpdateDTO();
        slideUpdateDTO.setBody(SlideDAOFactory.BODY);
        slideUpdateDTO.setItemOrder(SlideDAOFactory.ORDER);

        return slideUpdateDTO;
    }
}
