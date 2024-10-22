package pl.cantabo.database.group;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(
        componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE
)
public interface GroupMapper {

    GroupInfoDTO groupDAO2GroupInfoDTO(GroupDAO groupDAO);

    GroupDAO groupCreateDTO2GroupDAO(GroupCreateDTO groupCreateDTO);

    GroupDAO groupUpdateDTO2GroupDAO(GroupUpdateDTO groupUpdateDTO);
}
