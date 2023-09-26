package one.around_music.service;

import one.around_music.dto.marker.RequestMarkerFindDto;
import org.springframework.http.ResponseEntity;

public interface MarkerService {
    ResponseEntity<?> findAllMarker(RequestMarkerFindDto requestMarkerFindDto);
}
