package advanced_server.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import advanced_server.errorshandling.ValidationConstants;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import org.hibernate.validator.constraints.Length;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class PutUserDto {

    @NotBlank(message = ValidationConstants.USER_AVATAR_NOT_NULL)
    private String avatar;

    @Length(min = 3, max = 100, message = ValidationConstants.EMAIL_SIZE_NOT_VALID)
    @Email(regexp = "^([\\w-\\.]+){1,64}@([\\w&&[^_]]+){2,255}\\.[a-z]{2,}$",
            message = ValidationConstants.USER_EMAIL_NOT_VALID)
    @NotBlank(message = ValidationConstants.USER_EMAIL_NOT_NULL)
    private String email;

    @NotBlank(message = ValidationConstants.USERNAME_HAS_TO_BE_PRESENT)
    @Length(min = 3, max = 25, message = ValidationConstants.USERNAME_SIZE_NOT_VALID)
    private String name;

    @NotBlank(message = ValidationConstants.USER_ROLE_NOT_NULL)
    private String role;
}
