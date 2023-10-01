package one.around_music.dto.user;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
public class RequestUserUpdateDto {
    @Schema(example = "/profile/new.png")
    private String profileImg;
}
