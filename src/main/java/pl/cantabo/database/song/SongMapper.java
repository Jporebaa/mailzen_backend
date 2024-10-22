package pl.cantabo.database.song;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import pl.cantabo.database.song.songCategory.SongCategoryMapper;

@Mapper(
        componentModel = "spring",
        uses = {SongCategoryMapper.class},
        unmappedTargetPolicy = ReportingPolicy.IGNORE
)
public interface SongMapper {

    SongInfoDTO songDAO2SongInfoDTO(SongDAO songDAO);

    SongDAO songCreateDTO2SongDAO(SongCreateDTO songCreateDTO);

    SongDAO songUpdateDTO2SongDAO(SongUpdateDTO songUpdateDTO);
}
