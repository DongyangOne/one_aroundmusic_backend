package one.around_music.service.impl;

import lombok.RequiredArgsConstructor;
import one.around_music.common.dto.CommonResponse;
import one.around_music.domain.Marker;
import one.around_music.dto.marker.RequestMarkerFindDto;
import one.around_music.repository.marker.MarkerJpaRepository;
import one.around_music.service.MarkerService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MarkerServiceImpl implements MarkerService {

    private final MarkerJpaRepository markerJpaRepository;

    @Override
    public ResponseEntity<?> findAllMarker(RequestMarkerFindDto dto) {
        List<Marker> markerList = markerJpaRepository.findAllByLatitudeBetweenAndLongitudeBetween(dto.getCurrent_latitude()-0.4, dto.getCurrent_latitude()+0.4, dto.getCurrent_longitude()-0.4, dto.getCurrent_longitude()+0.4);
        return CommonResponse.createResponse(HttpStatus.OK.value(), "주변 부표를 조회합니다.", markerList);
    }

}
