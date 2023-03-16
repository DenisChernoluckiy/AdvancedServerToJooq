package advanced_server.controller;

import advanced_server.dto.AuthDto;
import advanced_server.dto.CustomSuccessResponse;
import advanced_server.dto.RegisterUserDto;
import advanced_server.service.AuthService;
import lombok.RequiredArgsConstructor;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
@RequiredArgsConstructor
@RequestMapping("/api/v1/auth/")
public class AuthController {

    private final AuthService authService;

    @PostMapping("/register")
    public ResponseEntity<CustomSuccessResponse> registerUser(@RequestBody @Validated RegisterUserDto dto) {
        return CustomSuccessResponse.getSuccessWithData(authService.registerUser(dto));
    }

    @PostMapping("/login")
    public ResponseEntity<CustomSuccessResponse> authorizeUser(@RequestBody @Validated AuthDto dto) {
        return CustomSuccessResponse.getSuccessWithData(authService.authorizeUser(dto));
    }
}
