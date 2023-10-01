package one.around_music.repository.ar;

import one.around_music.domain.Ar;
import one.around_music.domain.Marker;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ArJpaRepository extends JpaRepository<Ar, Long>, ArCustomRepository{
}
