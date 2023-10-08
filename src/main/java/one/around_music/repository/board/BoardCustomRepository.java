package one.around_music.repository.board;

import one.around_music.domain.User;
import one.around_music.vo.BoardVo;

import java.util.List;

public interface BoardCustomRepository {

    List<BoardVo> findAllByUser(User user);

}
