package one.around_music.repository.story;

import one.around_music.domain.Story;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StoryJpaRepository extends JpaRepository<Story, Long>, StoryCustomRepository {
}
