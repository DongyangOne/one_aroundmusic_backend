package one.around_music.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import one.around_music.dto.board.RequestBoardSaveDto;
import one.around_music.service.BoardService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/board")
@Tag(name = "Board Api", description = "게시글 API")
public class BoardController {
    private final BoardService boardService;

    @Operation(summary = "Save Board", description = "게시글 게시 API")
    @ApiResponses(value = {
    })
    @PostMapping
    public ResponseEntity<?> saveBoard(@RequestBody RequestBoardSaveDto dto) {
        return boardService.saveBoard(dto);
    }

    @Operation(summary = "Find Board", description = "게시글 조회 API")
    @ApiResponses(value = {
    })
    @GetMapping
    public ResponseEntity<?> findBoard() {
        return boardService.findBoard();
    }

    @Operation(summary = "Delete Board", description = "게시글 삭제 API")
    @ApiResponses(value = {
    })
    @DeleteMapping("/{boardId}")
    public ResponseEntity<?> deleteBoard(@PathVariable Long boardId) {
        return boardService.deleteBaord(boardId);
    }

}
