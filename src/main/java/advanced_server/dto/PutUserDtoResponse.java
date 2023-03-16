package advanced_server.dto;

import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class PutUserDtoResponse {

    String avatar;
    String email;
    String name;
    String role;
    UUID id;
}
