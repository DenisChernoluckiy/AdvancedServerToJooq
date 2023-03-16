package advanced_server.controller;

import advanced_server.dto.BaseSuccessResponse;
import advanced_server.dto.CustomSuccessResponse;
import advanced_server.dto.PutUserDto;
import advanced_server.security.UserDetailsImpl;
import advanced_server.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@Validated
@RestController
@CrossOrigin
@RequiredArgsConstructor
@RequestMapping("/api/v1/user")
public class UserController {

    private final UserService userService;

    @GetMapping
    public ResponseEntity<CustomSuccessResponse> getAllUsersInfo() {
        return CustomSuccessResponse.getSuccessWithData(userService.getAllUsersInfo());
    }

    @GetMapping("/{id}")
    public ResponseEntity<CustomSuccessResponse> getUserInfoById(@PathVariable UUID id) {
        return CustomSuccessResponse.getSuccessWithData(userService.getUserInfoById(id));
    }

    @GetMapping("/info")
    public ResponseEntity<CustomSuccessResponse> getUserInfo(Authentication authentication) {
        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
        return CustomSuccessResponse.getSuccessWithData(userService.getUserInfoById(userDetails.getId()));
    }

    @PutMapping
    public ResponseEntity<CustomSuccessResponse> changeUserInfo(@RequestBody
                                                                @Validated PutUserDto dto,
                                                                Authentication authentication) {
        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
        return CustomSuccessResponse.getSuccessWithData(userService.changeUserInfo(dto, userDetails.getId()));
    }

    @DeleteMapping("/{uuid}")
    public ResponseEntity<BaseSuccessResponse> deleteUser(@PathVariable UUID uuid) {
        userService.deleteUser(uuid);
        return new ResponseEntity(BaseSuccessResponse.ok(), HttpStatus.OK);
    }
}
