package advanced_server.repository;

import advanced_server.dto.PublicUserView;
import advanced_server.dto.PutUserDtoResponse;
import advanced_server.entity.UserEntity;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface UserRepository {


    PublicUserView getUserInfoById(UUID id);

    List<PublicUserView> getUsersInfo();

    Optional<UserEntity> getOptionalUserInfoById(UUID id);

    PutUserDtoResponse changeUserInfo(UUID id, String avatar, String email, String name, String role);

    PutUserDtoResponse changeUserInfoByEmail(String avatar, String email, String name, String role);

    void deleteUser(UUID id);

    void deleteUser(String email);
}
