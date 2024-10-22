package pl.cantabo.database.slide;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(
        componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE
)
public interface SlideMapper {

    SlideInfoDTO slideDAO2SlideInfoDTO(SlideDAO slideDAO);

    SlideDAO slideCreateDTO2SlideDAO(SlideCreateDTO slideCreateDTO);

    SlideDAO slideUpdateDTO2SlideDAO(SlideUpdateDTO slideUpdateDTO);
}
