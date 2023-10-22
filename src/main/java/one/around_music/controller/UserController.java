package one.around_music.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import one.around_music.common.dto.SwaggerConfig;
import one.around_music.dto.user.RequestUserLoginDto;
import one.around_music.dto.user.RequestUserSaveDto;
import one.around_music.dto.user.RequestUserUpdateDto;
import one.around_music.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/user")
@Tag(name = "User Api", description = "회원 API")
public class UserController {

    private final UserService userService;

    @Operation(summary = "Save User", description = "회원가입")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", content = @Content(mediaType = "application/json", examples = {@ExampleObject(value = SwaggerConfig.REGISTER_SUCCESS_RESPONSE)})),
    })
    @PostMapping
    public ResponseEntity<?> saveUser(@RequestBody RequestUserSaveDto dto) {
        return userService.saveUser(dto);
    }

    @Operation(summary = "Login", description = "로그인")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", content = @Content(mediaType = "application/json", examples = {@ExampleObject(value = SwaggerConfig.LOGIN_SUCCESS_RESPONSE)})),
    })
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody RequestUserLoginDto dto) {
        return userService.login(dto);
    }
    
    @Operation(summary = "Update ProfileImg", description = "프로필 사진 변경")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", content = @Content(mediaType = "application/json", examples = {@ExampleObject(value = SwaggerConfig.UPDATE_PROFILEIMG_SUCCESS_RESPONSE)})),
    })
    @PatchMapping("/profileImg")
    public ResponseEntity<?> updateProfileImg(@RequestBody RequestUserUpdateDto dto) {
        return userService.updateProfileImg(dto);
    }

    @Operation(summary = "Find My Info", description = "내 정보 조회")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", content = @Content(mediaType = "application/json", examples = {@ExampleObject(value = SwaggerConfig.FIND_MY_INFO_SUCCESS_RESPONSE)})),
    })
    @GetMapping("/my")
    public ResponseEntity<?> findUser() {
        return userService.findUser();
    }

}
