package one.around_music.service.impl;

import lombok.RequiredArgsConstructor;
import one.around_music.common.dto.CommonResponse;
import one.around_music.common.dto.CustomException;
import one.around_music.common.util.SecurityUtil;
import one.around_music.domain.Board;
import one.around_music.domain.User;
import one.around_music.dto.board.RequestBoardSaveDto;
import one.around_music.repository.board.BoardJpaRepository;
import one.around_music.repository.user.UserJpaRepository;
import one.around_music.service.BoardService;
import one.around_music.vo.BoardVo;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BoardServiceImpl implements BoardService {

    private final UserJpaRepository userJpaRepository;
    private final BoardJpaRepository boardJpaRepository;

    @Override
    public ResponseEntity<?> saveBoard(RequestBoardSaveDto dto) {
        User findUser = SecurityUtil.getCurrentUserId(userJpaRepository);
        boardJpaRepository.save(Board.builder().content(dto.getContent()).img(dto.getImg()).location(dto.getLocation()).user(findUser).build());
        return CommonResponse.createResponse(HttpStatus.OK.value(), "게시글 작성에 성공했습니다.");
    }

    @Override
    public ResponseEntity<?> findBoard() {
        User findUser = SecurityUtil.getCurrentUserId(userJpaRepository);
        List<BoardVo> boards = boardJpaRepository.findAllByUser(findUser);
        return CommonResponse.createResponse(HttpStatus.OK.value(), "게시글을 조회합니다.", boards);
    }

    @Override
    public ResponseEntity<?> deleteBaord(Long boardId) {
        Optional<Board> findBoard = boardJpaRepository.findById(boardId);
        if(findBoard.isEmpty()) {
            throw new CustomException("존재하지 않는 게시글 입니다.", HttpStatus.NOT_FOUND);
        }
        boardJpaRepository.deleteById(boardId);
        return CommonResponse.createResponse(HttpStatus.OK.value(), "게시글 삭제에 성공했습니다.");
    }
}
