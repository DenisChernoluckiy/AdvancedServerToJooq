package advanced_server.mappers;

import advanced_server.dto.GetNewsOutDto;
import advanced_server.dto.NewsDto;
import advanced_server.entity.NewsEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface NewsMapper {

    NewsMapper INSTANCE = Mappers.getMapper(NewsMapper.class);

    @Mappings({
            @Mapping(source = "dto.description", target = "description"),
            @Mapping(source = "dto.image", target = "image"),
            @Mapping(source = "dto.title", target = "title"),
            @Mapping(target = "tags", ignore = true),
            @Mapping(target = "id", ignore = true),
            @Mapping(target = "user", ignore = true),
            @Mapping(target = "userName", ignore = true)

    })
    NewsEntity newsDtoToNewsEntity(NewsDto dto);

    @Mappings({
            @Mapping(source = "description", target = "description"),
            @Mapping(source = "id", target = "id"),
            @Mapping(target = "image", ignore = true),
            @Mapping(source = "tags", target = "tags"),
            @Mapping(source = "title", target = "title"),
            @Mapping(target = "userId", ignore = true),
            @Mapping(target = "username", ignore = true)
    })
    GetNewsOutDto entitiesToGetNewsOutDto(NewsEntity entity);
}
