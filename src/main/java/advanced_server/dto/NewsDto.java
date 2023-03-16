package advanced_server.dto;


import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import advanced_server.errorshandling.ValidationConstants;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class NewsDto {

    @Size(min = 3, max = 160,
            message = ValidationConstants.NEWS_DESCRIPTION_SIZE_NOT_VALID)
    @NotBlank(message = ValidationConstants.NEWS_DESCRIPTION_HAS_TO_BE_PRESENT)
    private String description;

    @Size(min = 3, max = 130,
            message = ValidationConstants.NEWS_IMAGE_LENGTH)
    @NotBlank(message = ValidationConstants.NEWS_IMAGE_HAS_TO_BE_PRESENT)
    private String image;

    private Set<@NotBlank(message = ValidationConstants.TAGS_NOT_VALID) String> tags;

    @Size(min = 3, max = 160,
            message = ValidationConstants.NEWS_TITLE_SIZE)
    @NotBlank(message = ValidationConstants.NEWS_TITLE_NOT_NULL)
    private String title;
}
