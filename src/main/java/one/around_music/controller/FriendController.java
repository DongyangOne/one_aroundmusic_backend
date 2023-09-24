package one.around_music.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import one.around_music.common.dto.SwaggerConfig;
import one.around_music.dto.friend.RequestFriendSaveDto;
import one.around_music.service.FriendService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/friend")
@Tag(name = "Friend Api", description = "친구 API")
public class FriendController {

    private final FriendService friendService;

    @Operation(summary = "Add Friend", description = "친구 추가 API")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", content = @Content(mediaType = "application/json", examples = {@ExampleObject(value = SwaggerConfig.ADD_FRIEND_SUCESS_RESPONSE)})),
    })
    @PostMapping
    public ResponseEntity<?> addFriend(@RequestBody RequestFriendSaveDto dto) {
        return friendService.addFriend(dto);
    }

}
