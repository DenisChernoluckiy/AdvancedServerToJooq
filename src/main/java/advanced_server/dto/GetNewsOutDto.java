package advanced_server.dto;

import java.util.List;
import java.util.UUID;

import advanced_server.entity.TagEntity;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@Data
@NoArgsConstructor
@Accessors(chain = true)
public class GetNewsOutDto {

    private String description;
    private Long id;
    private String image;
    private List<TagEntity> tags;
    private String title;
    private UUID userId;
    private String username;
}
