package one.around_music.dto.reward;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
public class RequestSelectRewardDto {

    @Schema(example = "2")
    private Long current_id;

    @Schema(example = "5")
    private Long select_id;

}
