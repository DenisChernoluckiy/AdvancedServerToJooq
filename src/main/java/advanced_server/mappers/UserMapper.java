package advanced_server.mappers;

import java.util.UUID;

import advanced_server.dto.LoginUserDto;
import advanced_server.dto.PutUserDto;
import advanced_server.dto.PutUserDtoResponse;
import advanced_server.dto.RegisterUserDto;
import advanced_server.entity.UserEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface UserMapper {

    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    @Mappings({
            @Mapping(target = "id", ignore = true),
            @Mapping(source = "dto.avatar", target = "avatar"),
            @Mapping(source = "dto.email", target = "email"),
            @Mapping(source = "dto.name", target = "name"),
            @Mapping(source = "dto.role", target = "role"),
            @Mapping(target = "password", ignore = true)
    })
    UserEntity registerUserDtoToUserEntity(RegisterUserDto dto);

    @Mappings({
            @Mapping(source = "entity.id", target = "id"),
            @Mapping(source = "entity.avatar", target = "avatar"),
            @Mapping(source = "entity.email", target = "email"),
            @Mapping(source = "entity.name", target = "name"),
            @Mapping(source = "entity.role", target = "role"),
            @Mapping(target = "token", ignore = true)
    })
    LoginUserDto userEntityToLoginUserDto(UserEntity entity);

    @Mappings({
            @Mapping(target = "id"),
            @Mapping(source = "dto.avatar", target = "avatar"),
            @Mapping(source = "dto.email", target = "email"),
            @Mapping(source = "dto.name", target = "name"),
            @Mapping(source = "dto.role", target = "role")
    })
    PutUserDtoResponse putUserDtoToPutUserDtoResponse(PutUserDto dto, UUID id);
}
