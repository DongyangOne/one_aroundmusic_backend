package one.around_music.dto.ar;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
public class RequestArSaveDto {

    @Schema(example = "string")
    private String youtubeId;

    @Schema(example = "title")
    private String title;

    @Schema(example = "/thumb/default.png")
    private String thumbnail;

    @Schema(example = "37.498063")
    private double latitude;

    @Schema(example = "126.867021")
    private double longitude;
}
