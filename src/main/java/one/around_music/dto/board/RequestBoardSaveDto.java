package one.around_music.dto.board;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
public class RequestBoardSaveDto {
    @Schema(example = "게시글 내용")
    private String content;
    @Schema(example = "서울시 구로구 고척동 234-5")
    private String location;
    @Schema(example = "/board/test.png")
    private String img;
}
