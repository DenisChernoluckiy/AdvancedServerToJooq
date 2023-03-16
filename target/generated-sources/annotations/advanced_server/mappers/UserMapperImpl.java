package advanced_server.mappers;

import advanced_server.dto.LoginUserDto;
import advanced_server.dto.PutUserDto;
import advanced_server.dto.PutUserDtoResponse;
import advanced_server.dto.RegisterUserDto;
import advanced_server.entity.UserEntity;
import java.util.UUID;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-03-15T19:35:40+0300",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 17.0.5 (Amazon.com Inc.)"
)
@Component
public class UserMapperImpl implements UserMapper {

    @Override
    public UserEntity registerUserDtoToUserEntity(RegisterUserDto dto) {
        if ( dto == null ) {
            return null;
        }

        UserEntity userEntity = new UserEntity();

        userEntity.setAvatar( dto.getAvatar() );
        userEntity.setEmail( dto.getEmail() );
        userEntity.setName( dto.getName() );
        userEntity.setRole( dto.getRole() );

        return userEntity;
    }

    @Override
    public LoginUserDto userEntityToLoginUserDto(UserEntity entity) {
        if ( entity == null ) {
            return null;
        }

        LoginUserDto loginUserDto = new LoginUserDto();

        loginUserDto.setId( entity.getId() );
        loginUserDto.setAvatar( entity.getAvatar() );
        loginUserDto.setEmail( entity.getEmail() );
        loginUserDto.setName( entity.getName() );
        loginUserDto.setRole( entity.getRole() );

        return loginUserDto;
    }

    @Override
    public PutUserDtoResponse putUserDtoToPutUserDtoResponse(PutUserDto dto, UUID id) {
        if ( dto == null && id == null ) {
            return null;
        }

        PutUserDtoResponse putUserDtoResponse = new PutUserDtoResponse();

        if ( dto != null ) {
            putUserDtoResponse.setAvatar( dto.getAvatar() );
            putUserDtoResponse.setEmail( dto.getEmail() );
            putUserDtoResponse.setName( dto.getName() );
            putUserDtoResponse.setRole( dto.getRole() );
        }
        putUserDtoResponse.setId( id );

        return putUserDtoResponse;
    }
}
