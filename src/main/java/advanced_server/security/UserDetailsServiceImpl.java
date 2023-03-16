package advanced_server.security;

import java.util.UUID;

import advanced_server.entity.UserEntity;
import advanced_server.errorshandling.CustomException;
import advanced_server.errorshandling.ErrorEnum;
import advanced_server.repository.AuthRepository;
import lombok.RequiredArgsConstructor;

import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService {

    private final AuthRepository authRepository;

    @Override
    public UserDetailsImpl loadUserByUsername(String id) throws CustomException {
        UserEntity userEntity = authRepository.findByIdJooq(UUID.fromString(id))
                .orElseThrow(() -> new CustomException(ErrorEnum.USER_NOT_FOUND));
        return UserDetailsImpl.userEntityToUserDetailsImpl(userEntity);
    }
}
