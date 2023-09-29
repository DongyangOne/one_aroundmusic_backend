package one.around_music.dto.reward;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import one.around_music.enums.RewardType;

@Data
public class RequestRewardSaveDto {

    @Schema(example = "WALKING | POPULARITY | LISTENING")
    private RewardType rewardType;

    @Schema(example = "/walk/default.png")
    private String reward;

}
