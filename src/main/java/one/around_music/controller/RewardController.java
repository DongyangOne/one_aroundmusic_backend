package one.around_music.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import one.around_music.common.dto.SwaggerConfig;
import one.around_music.dto.reward.RequestRewardSaveDto;
import one.around_music.dto.reward.RequestSelectRewardDto;
import one.around_music.service.RewardService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/reward")
@Tag(name = "Reward Api", description = "리워드 API")
public class RewardController {

    private final RewardService rewardService;

    @Operation(summary = "Save Reward", description = "리워드 저장")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", content = @Content(mediaType = "application/json", examples = {@ExampleObject(value = SwaggerConfig.REWARD_SAVE_SUCCESS_RESPONSE)})),
    })
    @PostMapping
    public ResponseEntity<?> saveReward(@RequestBody RequestRewardSaveDto dto) {
        return rewardService.saveReward(dto);
    }

    @Operation(summary = "Find All Reward", description = "리워드 전체 조회 \n rewardType = walk | pop | listen")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", content = @Content(mediaType = "application/json", examples = {@ExampleObject(value = SwaggerConfig.FIND_ALL_REWARD_SUCCESS_RESPONSE)})),
    })
    @GetMapping("/{rewardType}")
    public ResponseEntity<?> findAllReward(@PathVariable String rewardType) {
        return rewardService.findAllReward(rewardType);
    }

    @Operation(summary = "Select Reward", description = "리워드 적용")
    @PatchMapping
    public ResponseEntity<?> selectReward(@RequestBody RequestSelectRewardDto dto) {
        return rewardService.selectReward(dto);
    }

}
