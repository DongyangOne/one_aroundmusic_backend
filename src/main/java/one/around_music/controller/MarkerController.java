package one.around_music.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import one.around_music.common.dto.SwaggerConfig;
import one.around_music.dto.marker.RequestMarkerFindDto;
import one.around_music.service.MarkerService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/marker")
@Tag(name = "Marker Api", description = "마커 API")
public class MarkerController {

    private final MarkerService markerService;

    @Operation(summary = "Find All Marker", description = "주변 마커 전체 조회")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", content = @Content(mediaType = "application/json", examples = {@ExampleObject(value = SwaggerConfig.FIND_ALL_MARKER_SUCCESS_RESPONSE)})),
    })
    @PostMapping()
    public ResponseEntity<?> findAllMarker(@RequestBody RequestMarkerFindDto dto) {
        return markerService.findAllMarker(dto);
    }

}
