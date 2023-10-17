package one.around_music.dto.reward;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
public class RequestSelectRewardDto {

    @Schema(example = "walk | pop | listen")
    private String rewardType;

    @Schema(example = "5")
    private Long select_id;

}
