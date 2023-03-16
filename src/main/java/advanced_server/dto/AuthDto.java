package advanced_server.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import advanced_server.errorshandling.ValidationConstants;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import javax.validation.constraints.Size;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class AuthDto {

    @Size(min = 3, max = 100, message = ValidationConstants.EMAIL_SIZE_NOT_VALID)
    @Email(regexp = "^([\\w-\\.]+){1,64}@([\\w&&[^_]]+){2,255}\\.[a-z]{2,}$",
            message = ValidationConstants.USER_EMAIL_NOT_VALID)
    @NotBlank(message = ValidationConstants.USER_EMAIL_NOT_NULL)
    private String email;

    @NotNull(message = ValidationConstants.PASSWORD_NOT_VALID)
    private String password;
}
