package one.around_music.service;

import one.around_music.dto.story.RequestStorySaveDto;
import org.springframework.http.ResponseEntity;

public interface StoryService {

    ResponseEntity<?> saveStory(RequestStorySaveDto dto);
    ResponseEntity<?> findStoryUser();
    ResponseEntity<?> findStory(Long userId);


}
