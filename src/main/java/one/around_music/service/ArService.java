package one.around_music.service;

import one.around_music.dto.ar.RequestArSaveDto;
import org.springframework.http.ResponseEntity;

public interface ArService {

    ResponseEntity<?> saveAr(RequestArSaveDto dto);
    ResponseEntity<?> findAllAr();
    ResponseEntity<?> deleteAr(Long arId);

}
