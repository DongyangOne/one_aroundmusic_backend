package one.around_music.repository.board;

import one.around_music.domain.Board;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BoardJpaRepository extends JpaRepository<Board, Long>, BoardCustomRepository {
}
