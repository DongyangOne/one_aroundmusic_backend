package one.around_music.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import one.around_music.common.dto.SwaggerConfig;
import one.around_music.dto.story.RequestStorySaveDto;
import one.around_music.service.StoryService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/story")
@Tag(name = "Story Api", description = "스토리 API")
public class StoryController {

    private final StoryService storyService;

    @Operation(summary = "Save Story", description = "스토리 게시 API")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", content = @Content(mediaType = "application/json", examples = {@ExampleObject(value = SwaggerConfig.STORY_SAVE_SUCCESS_RESPONSE)})),
    })
    @PostMapping
    public ResponseEntity<?> saveStory(@RequestBody RequestStorySaveDto dto) {
        return storyService.saveStory(dto);
    }

    @Operation(summary = "Find Story", description = "스토리 조회 API")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", content = @Content(mediaType = "application/json", examples = {@ExampleObject(value = SwaggerConfig.FIND_STORY_SUCCESS_RESPONSE)})),
    })
    @GetMapping("/{userId}")
    public ResponseEntity<?> findStory(@PathVariable Long userId) {
        return storyService.findStory(userId);
    }

    @Operation(summary = "Find Story User", description = "스토리 게시 유저 조회 API")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", content = @Content(mediaType = "application/json", examples = {@ExampleObject(value = SwaggerConfig.FIND_STORY_USER_SUCCESS_RESPONSE)})),
    })
    @GetMapping
    public ResponseEntity<?> findStoryUser() {
        return storyService.findStoryUser();
    }

}
