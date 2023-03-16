package advanced_server.service;

import advanced_server.dto.PublicUserView;
import advanced_server.dto.PutUserDto;
import advanced_server.dto.PutUserDtoResponse;
import advanced_server.repository.PublicUserView1;

import java.util.List;
import java.util.UUID;

public interface UserService {

    List<PublicUserView> getAllUsersInfo();

    PublicUserView getUserInfoById(UUID id);

    PutUserDtoResponse changeUserInfo(PutUserDto dto, UUID userId);

    void deleteUser(UUID userId);
}

