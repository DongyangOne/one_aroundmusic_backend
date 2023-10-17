package one.around_music.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import one.around_music.dto.music.RequestMusicSaveDto;
import one.around_music.service.MusicService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/music")
@Tag(name = "Music Api", description = "음악 API")
public class MusicController {
    private final MusicService musicService;

    @Operation(summary = "Save Music", description = "음악 저장 API")
    @ApiResponses(value = {
    })
    @PostMapping
    public ResponseEntity<?> saveMusic(@RequestBody RequestMusicSaveDto dto) {
        return musicService.saveMusic(dto);
    }

    @Operation(summary = "Find All Music", description = "음악 전체 조회 API")
    @ApiResponses(value = {
    })
    @GetMapping
    public ResponseEntity<?> findAllMusic() {
        return musicService.findAllMusic();
    }

}
