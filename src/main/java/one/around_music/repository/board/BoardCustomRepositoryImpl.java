package one.around_music.repository.board;

import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import one.around_music.domain.QBoard;
import one.around_music.domain.User;
import one.around_music.vo.BoardVo;
import one.around_music.vo.UserVo;

import java.util.List;

@RequiredArgsConstructor
public class BoardCustomRepositoryImpl implements BoardCustomRepository{

    private final JPAQueryFactory queryFactory;

    @Override
    public List<BoardVo> findAllByUser(User user) {
        QBoard b = QBoard.board;
        return queryFactory.select(
                Projections.constructor(
                        BoardVo.class,
                        b.id,
                        Projections.constructor(
                                UserVo.class,
                                b.user.id,
                                b.user.nickname,
                                b.user.profileImg
                        ),
                        b.content,
                        b.location,
                        b.img,
                        b.createdDate
                )
        ).from(b)
                .where(b.user.eq(user))
                .fetch();
    }

}
