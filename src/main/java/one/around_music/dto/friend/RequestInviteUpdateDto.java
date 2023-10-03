package one.around_music.dto.friend;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
public class RequestInviteUpdateDto {
    @Schema(example = "1")
    private Long id;
    @Schema(example = "Y | N")
    private String accept;
}
