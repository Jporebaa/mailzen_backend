package pl.cantabo.database.profile;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(
        componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE
)
public interface ProfileMapper {

    ProfileInfoDTO profileDAO2ProfileInfoDTO(ProfileDAO profileDAO);

    ProfileDAO profileCreateDTO2ProfileDAO(ProfileCreateDTO profileCreateDTO);

    ProfileDAO profileUpdateDTO2ProfileDAO(ProfileUpdateDTO profileUpdateDTO);
}
