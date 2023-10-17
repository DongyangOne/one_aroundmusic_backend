package one.around_music.dto.story;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
public class RequestStorySaveDto {

    @Schema(example = "v_gO_P8gug8")
    private String youtubeId;

    @Schema(example = "퀸카(Queencard)")
    private String title;

    @Schema(example = "https://i.ytimg.com/vi/v_gO_P8gug8/hqdefault.jpg")
    private String thumbnail;

}
