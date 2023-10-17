package one.around_music.service;

import one.around_music.dto.board.RequestBoardSaveDto;
import org.springframework.http.ResponseEntity;

public interface BoardService {
    ResponseEntity<?> saveBoard(RequestBoardSaveDto dto);
    ResponseEntity<?> findBoard();

    ResponseEntity<?> deleteBaord(Long boardId);
}
