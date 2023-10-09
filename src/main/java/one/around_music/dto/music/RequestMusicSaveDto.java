package one.around_music.dto.music;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class RequestMusicSaveDto {
    @Schema(example = "string")
    private String youtubeId;

    @Schema(example = "title")
    private String title;

    @Schema(example = "/thumb/default.png")
    private String thumbnail;
}
