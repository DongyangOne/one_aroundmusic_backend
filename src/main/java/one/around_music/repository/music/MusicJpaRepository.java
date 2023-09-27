package one.around_music.repository.music;

import one.around_music.domain.Music;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MusicJpaRepository extends JpaRepository<Music, Long> {
    Optional<Music> findByYoutubId(String youtubeId);
}
