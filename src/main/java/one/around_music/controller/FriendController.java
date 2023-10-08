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
import one.around_music.dto.friend.RequestInviteUpdateDto;
import one.around_music.service.FriendService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/friend")
@Tag(name = "Friend Api", description = "친구 API")
public class FriendController {

    private final FriendService friendService;

    @Operation(summary = "Add Friend", description = "친구 추가 API")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", content = @Content(mediaType = "application/json", examples = {@ExampleObject(value = SwaggerConfig.ADD_FRIEND_SUCCESS_RESPONSE)})),
    })
    @PostMapping
    public ResponseEntity<?> addFriend(@RequestBody RequestFriendSaveDto dto) {
        return friendService.addFriend(dto);
    }

    @Operation(summary = "Delete Friend", description = "친구 삭제 API")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", content = @Content(mediaType = "application/json", examples = {@ExampleObject(value = SwaggerConfig.DELETE_FRIEND_SUCCESS_RESPONSE)})),
    })
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteFriend(@PathVariable Long id) {
        return friendService.deleteFriend(id);
    }

    @Operation(summary = "Find All Recive Invite", description = "받은 친구 요청 리스트 조회 API")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", content = @Content(mediaType = "application/json", examples = {@ExampleObject(value = SwaggerConfig.FIND_ALL_RECIVE_INVITE_SUCCESS_RESPONSE)})),
    })
    @GetMapping("/recive")
    public ResponseEntity<?> findAllReciveInvite() {
        return friendService.findAllReciveInvite();
    }

    @Operation(summary = "Find All Send Invite", description = "보낸 친구 요청 리스트 조회 API")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", content = @Content(mediaType = "application/json", examples = {@ExampleObject(value = SwaggerConfig.FIND_ALL_SEND_INVITE_SUCCESS_RESPONSE)})),
    })
    @GetMapping("/send")
    public ResponseEntity<?> findAllSendInvite() {
        return friendService.findAllSendInvite();
    }

    @Operation(summary = "Update Invite", description = "친구 요청 수락, 거부 API")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", content = @Content(mediaType = "application/json", examples = {@ExampleObject(value = SwaggerConfig.UPDATE_INVITE_SUCCESS_RESPONSE)})),
    })
    @PatchMapping
    public ResponseEntity<?> updateInvite(@RequestBody RequestInviteUpdateDto dto) {
        return friendService.updateInvite(dto);
    }

    @Operation(summary = "Find All Friends", description = "친구 리스트 조회 API")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", content = @Content(mediaType = "application/json", examples = {@ExampleObject(value = SwaggerConfig.FIND_ALL_FRIEND_SUCCESS_RESPONSE)})),
    })
    @GetMapping()
    public ResponseEntity<?> findAllFriends() {
        return friendService.findAllFriends();
    }

    @GetMapping("/user")
    public ResponseEntity<?> findAllUserExceptFriends() {
        return friendService.findAllUserExceptFriends();
    }

}
