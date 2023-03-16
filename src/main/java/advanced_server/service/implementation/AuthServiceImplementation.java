package advanced_server.service.implementation;

import advanced_server.dto.AuthDto;
import advanced_server.dto.LoginUserDto;
import advanced_server.dto.RegisterUserDto;
import advanced_server.entity.UserEntity;
import advanced_server.errorshandling.CustomException;
import advanced_server.errorshandling.ErrorEnum;
import advanced_server.mappers.UserMapper;
import advanced_server.repository.AuthRepository;
import advanced_server.security.JwtProvider;
import advanced_server.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthServiceImplementation implements AuthService {
    private final AuthRepository authRepository;
    private final JwtProvider jwtProvider;
    private final PasswordEncoder passwordEncoder;

    @Override
    public LoginUserDto registerUser(RegisterUserDto dto) {
        if(authRepository.existByEmail(dto.getEmail()))
            throw new CustomException(ErrorEnum.USER_ALREADY_EXISTS);

        dto.setRole(dto.getRole().toLowerCase());
        if (!dto.getRole().equals("admin")) {
            dto.setRole("user");
        }

        UserEntity userEntityForRegister = UserMapper.INSTANCE.registerUserDtoToUserEntity(dto);
        userEntityForRegister.setPassword(passwordEncoder.encode(dto.getPassword()));
        userEntityForRegister.setAvatar(dto.getAvatar());
        authRepository.save(userEntityForRegister);
        LoginUserDto userLoginDto = UserMapper.INSTANCE.userEntityToLoginUserDto(userEntityForRegister);
        userLoginDto.setToken(jwtProvider.buildToken(userEntityForRegister.getId()));
        return userLoginDto;
    }

    @Override
    public LoginUserDto authorizeUser(AuthDto dto) {
        UserEntity entityForLogin = authRepository.findByEmailJooq(dto.getEmail()).orElseThrow(() ->
                new CustomException(ErrorEnum.USER_NOT_FOUND));

        if (!passwordEncoder.matches(dto.getPassword(), entityForLogin.getPassword())) {
            throw new CustomException(ErrorEnum.PASSWORD_NOT_VALID);
        }
        else {
            LoginUserDto loginUserDto = UserMapper.INSTANCE.userEntityToLoginUserDto(entityForLogin);
            loginUserDto.setToken(jwtProvider.buildToken(entityForLogin.getId()));
            return loginUserDto;
        }
    }
}
