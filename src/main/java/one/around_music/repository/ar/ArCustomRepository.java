package one.around_music.repository.ar;

import one.around_music.vo.ArVo;

import java.util.List;

public interface ArCustomRepository {
    List<ArVo> findArList();
}
