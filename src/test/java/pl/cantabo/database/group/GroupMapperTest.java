package pl.cantabo.database.group;

import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import pl.cantabo.database.configuration.MapperConfiguration;
import pl.cantabo.database.group.factory.GroupDAOFactory;
import pl.cantabo.database.group.factory.GroupDTOFactory;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = MapperConfiguration.class)
class GroupMapperTest {

    @Autowired
    private GroupMapper groupMapper;

    @Test
    void groupDAO2GroupInfoDTO() {
        // given
        GroupDAO groupDAO = GroupDAOFactory.defaultBuilder().build();

        // when
        GroupInfoDTO groupInfoDTO = groupMapper.groupDAO2GroupInfoDTO(groupDAO);

        // then
        assertNotNull(groupInfoDTO);
        SoftAssertions softly = new SoftAssertions();
        softly.assertThat(groupDAO.isDefaultItem()).isEqualTo(groupInfoDTO.getDefaultItem());
        softly.assertThat(groupDAO.getName()).isEqualTo(groupInfoDTO.getName());
        softly.assertAll();
    }

    @Test
    void groupCreateDTO2GroupDAO() {
        // given
        GroupCreateDTO groupCreateDTO = GroupDTOFactory.defaultGroupCreateDTO();

        // when
        GroupDAO groupDAO = groupMapper.groupCreateDTO2GroupDAO(groupCreateDTO);

        // then
        assertNotNull(groupDAO);
        SoftAssertions softly = new SoftAssertions();
        softly.assertThat(groupCreateDTO.getDefaultItem()).isEqualTo(groupDAO.isDefaultItem());
        softly.assertThat(groupCreateDTO.getName()).isEqualTo(groupDAO.getName());
        softly.assertAll();
    }

    @Test
    void groupUpdateDTO2GroupDAO() {

        // given
        GroupUpdateDTO groupUpdateDTO = GroupDTOFactory.defaultGroupUpdateDTO();

        // when
        GroupDAO groupDAO = groupMapper.groupUpdateDTO2GroupDAO(groupUpdateDTO);

        //then
        assertNotNull(groupDAO);
        SoftAssertions softly = new SoftAssertions();
        softly.assertThat(groupUpdateDTO.getDefaultItem()).isEqualTo(groupDAO.isDefaultItem());
        softly.assertThat(groupUpdateDTO.getName()).isEqualTo(groupDAO.getName());
        softly.assertAll();
    }
}
