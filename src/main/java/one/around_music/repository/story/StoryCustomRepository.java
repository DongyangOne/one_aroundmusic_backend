package one.around_music.repository.story;

import one.around_music.vo.MusicVo;
import one.around_music.vo.UserVo;

import java.util.List;

public interface StoryCustomRepository {
    List<MusicVo> findAllStory(Long userId);
    List<UserVo> findStoryUser();
}
