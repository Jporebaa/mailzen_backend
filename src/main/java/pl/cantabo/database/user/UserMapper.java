package pl.cantabo.database.user;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;
import pl.cantabo.utils.password.EncodedMapping;
import pl.cantabo.utils.password.PasswordEncoderMapper;

@Mapper(
        componentModel = "spring",
        uses = PasswordEncoderMapper.class,
        unmappedTargetPolicy = ReportingPolicy.IGNORE
)
public interface UserMapper {

    UserInfoDTO userDAO2UserInfoDTO(UserDAO userDAO);

    @Mapping(target = "password", qualifiedBy = EncodedMapping.class)
    UserDAO userCreateDTO2UserDAO(UserCreateDTO userCreateDTO);

    UserDAO userUpdateDTO2UserDAO(UserUpdateDTO userUpdateDTO);
}
