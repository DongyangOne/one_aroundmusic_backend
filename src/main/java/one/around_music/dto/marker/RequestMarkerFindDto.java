package one.around_music.dto.marker;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
public class RequestMarkerFindDto {
    @Schema(example = "37.498063")
    private double current_latitude;

    @Schema(example = "126.867021")
    private double current_longitude;
}
