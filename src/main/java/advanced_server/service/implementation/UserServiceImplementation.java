package advanced_server.service.implementation;

import advanced_server.dto.PublicUserView;
import advanced_server.dto.PutUserDto;
import advanced_server.dto.PutUserDtoResponse;
import advanced_server.entity.UserEntity;
import advanced_server.errorshandling.CustomException;
import advanced_server.errorshandling.ErrorEnum;
import advanced_server.repository.PublicUserView1;
import advanced_server.repository.UserRepository;
import advanced_server.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UserServiceImplementation implements UserService {

    private final UserRepository userRepository;

    @Override
    public PublicUserView getUserInfoById(UUID id) {
       return userRepository.getUserInfoById(id);
    }

    @Override
    public List<PublicUserView> getAllUsersInfo() {
        return userRepository.getUsersInfo();
    }

    @Override
    public void deleteUser(UUID userId) {
        UserEntity user = userRepository.getOptionalUserInfoById(userId)
                .orElseThrow(() -> new CustomException(ErrorEnum.USER_NOT_FOUND));
        userRepository.deleteUser(userId);
    }

    @Override
    public PutUserDtoResponse changeUserInfo(PutUserDto dto, UUID userId) {
        userRepository.getOptionalUserInfoById(userId).orElseThrow(() -> new CustomException(ErrorEnum.USER_NOT_FOUND));
        return userRepository.changeUserInfo(userId, dto.getAvatar(), dto.getEmail(), dto.getName(), dto.getRole());
    }


}
