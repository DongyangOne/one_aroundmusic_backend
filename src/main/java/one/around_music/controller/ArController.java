package one.around_music.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import one.around_music.common.dto.SwaggerConfig;
import one.around_music.dto.ar.RequestArSaveDto;
import one.around_music.service.ArService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/ar")
@Tag(name = "AR Api", description = "AR API")
public class ArController {

    private final ArService arService;

    @Operation(summary = "Save AR", description = "AR 게시 API")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", content = @Content(mediaType = "application/json", examples = {@ExampleObject(value = SwaggerConfig.AR_SAVE_SUCCESS_RESPONSE)})),
    })
    @PostMapping
    public ResponseEntity<?> saveAr(@RequestBody RequestArSaveDto dto) {
        return arService.saveAr(dto);
    }

    @Operation(summary = "Find All AR", description = "AR 전체 조회 API (최신 ar 10개 조회합니다.)")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", content = @Content(mediaType = "application/json", examples = {@ExampleObject(value = SwaggerConfig.FIND_ALL_AR_SUCCESS_RESPONSE)})),
    })
    @GetMapping
    public ResponseEntity<?> findAllAr() {
        return arService.findAllAr();
    }

    @Operation(summary = "Delete AR", description = "AR 삭제 API")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", content = @Content(mediaType = "application/json", examples = {@ExampleObject(value = SwaggerConfig.AR_DELETE_SUCCESS_RESPONSE)})),
    })
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteAr(@PathVariable Long id) {
        return arService.deleteAr(id);
    }

}
