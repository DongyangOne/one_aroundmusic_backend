package one.around_music.repository.marker;

import one.around_music.domain.Marker;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MarkerJpaRepository extends JpaRepository<Marker, Long> {

    List<Marker> findAllByLatitudeBetweenAndLongitudeBetween(double start_latitude, double end_latitude, double start_longitude, double end_longitude);

}
