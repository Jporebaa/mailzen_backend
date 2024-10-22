package pl.cantabo.database.song.songCategory;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(
        componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE
)
public interface SongCategoryMapper {

    SongCategoryInfoDTO songCategoryDAO2SongCategoryInfoDTO(SongCategoryDAO songCategoryDAO);

    SongCategoryDAO songCategoryCreateDTO2SongCategoryDAO(SongCategoryCreateDTO songCategoryCreateDTO);

    SongCategoryDAO songCategoryUpdateDTO2SongCategoryDAO(SongCategoryUpdateDTO songCategoryUpdateDTO);
}
