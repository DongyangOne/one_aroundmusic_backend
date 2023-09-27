package one.around_music.dto.user;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
public class RequestUserSaveDto {

    @Schema(example = "ex@gmail.com")
    private String email;

    @Schema(example = "nickname")
    private String nickname;

    @Schema(example = "string")
    private String socialToken;

}
