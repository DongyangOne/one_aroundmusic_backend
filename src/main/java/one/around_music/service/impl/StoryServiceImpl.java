package one.around_music.service.impl;

import lombok.RequiredArgsConstructor;
import one.around_music.common.dto.CommonResponse;
import one.around_music.common.util.SecurityUtil;
import one.around_music.domain.Music;
import one.around_music.domain.Story;
import one.around_music.domain.User;
import one.around_music.dto.story.RequestStorySaveDto;
import one.around_music.repository.music.MusicJpaRepository;
import one.around_music.repository.story.StoryJpaRepository;
import one.around_music.repository.user.UserJpaRepository;
import one.around_music.service.FriendService;
import one.around_music.service.StoryService;
import one.around_music.vo.MusicVo;
import one.around_music.vo.UserVo;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class StoryServiceImpl implements StoryService {

    private final StoryJpaRepository storyJpaRepository;
    private final UserJpaRepository userJpaRepository;
    private final MusicJpaRepository musicJpaRepository;
    private final FriendService friendService;

    @Override
    public ResponseEntity<?> saveStory(RequestStorySaveDto dto) {
        User findUser = SecurityUtil.getCurrentUserId(userJpaRepository);
        Optional<Music> findMusic = musicJpaRepository.findByYoutubId(dto.getYoutubeId());

        if(findMusic.isPresent()) {
            storyJpaRepository.save(Story.builder().user(findUser).music(findMusic.get()).build());
            return CommonResponse.createResponse(HttpStatus.OK.value(), "스토리 게시에 성공했습니다.");
        }

        Music music = musicJpaRepository.save(Music.builder().youtubId(dto.getYoutubeId()).thumbnail(dto.getThumbnail()).title(dto.getTitle()).build());
        storyJpaRepository.save(Story.builder().user(findUser).music(music).build());

        return CommonResponse.createResponse(HttpStatus.OK.value(), "스토리 게시에 성공했습니다.");
    }

    @Override
    public ResponseEntity<?> findStoryUser() {
        User findUser = SecurityUtil.getCurrentUserId(userJpaRepository);
        List<UserVo> findUsers = storyJpaRepository.findStoryUser(findUser.getId());
        return CommonResponse.createResponse(HttpStatus.OK.value(), "스토리를 게시한 친구 목록을 조회합니다.", findUsers);
    }

    @Override
    public ResponseEntity<?> findStory(Long userId) {
        List<MusicVo> storys = storyJpaRepository.findAllStory(userId);
        return CommonResponse.createResponse(HttpStatus.OK.value(), "스토리를 조회합니다.", storys);
    }

    @Override
    public ResponseEntity<?> findMyStory() {
        User findUser = SecurityUtil.getCurrentUserId(userJpaRepository);
        List<MusicVo> myStory = storyJpaRepository.findAllStory(findUser.getId());
        return CommonResponse.createResponse(HttpStatus.OK.value(), "나의 스토리를 조회합니다.", myStory);
    }
}
