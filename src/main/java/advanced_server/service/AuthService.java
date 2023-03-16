package advanced_server.service;

import advanced_server.dto.AuthDto;
import advanced_server.dto.LoginUserDto;
import advanced_server.dto.RegisterUserDto;

public interface AuthService {

    LoginUserDto registerUser(RegisterUserDto dto);
    LoginUserDto authorizeUser(AuthDto dto);
}
