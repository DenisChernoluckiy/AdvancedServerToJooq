package advanced_server.mappers;

import advanced_server.dto.GetNewsOutDto;
import advanced_server.dto.NewsDto;
import advanced_server.entity.NewsEntity;
import advanced_server.entity.TagEntity;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-03-15T19:35:40+0300",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 17.0.5 (Amazon.com Inc.)"
)
@Component
public class NewsMapperImpl implements NewsMapper {

    @Override
    public NewsEntity newsDtoToNewsEntity(NewsDto dto) {
        if ( dto == null ) {
            return null;
        }

        NewsEntity newsEntity = new NewsEntity();

        newsEntity.setDescription( dto.getDescription() );
        newsEntity.setImage( dto.getImage() );
        newsEntity.setTitle( dto.getTitle() );

        return newsEntity;
    }

    @Override
    public GetNewsOutDto entitiesToGetNewsOutDto(NewsEntity entity) {
        if ( entity == null ) {
            return null;
        }

        GetNewsOutDto getNewsOutDto = new GetNewsOutDto();

        getNewsOutDto.setDescription( entity.getDescription() );
        getNewsOutDto.setId( entity.getId() );
        List<TagEntity> list = entity.getTags();
        if ( list != null ) {
            getNewsOutDto.setTags( new ArrayList<TagEntity>( list ) );
        }
        getNewsOutDto.setTitle( entity.getTitle() );

        return getNewsOutDto;
    }
}
