package advanced_server.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class LoginUserDto {

    private String avatar;
    private String email;
    private UUID id;
    private String name;
    private String role;
    private String token;
}
