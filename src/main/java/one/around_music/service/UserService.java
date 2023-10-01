package one.around_music.service;

import one.around_music.common.dto.CommonResponse;
import one.around_music.dto.user.RequestUserLoginDto;
import one.around_music.dto.user.RequestUserSaveDto;
import one.around_music.dto.user.RequestUserUpdateDto;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;

public interface UserService {

    ResponseEntity<?> saveUser(RequestUserSaveDto dto);
    ResponseEntity<?> login(RequestUserLoginDto dto);
    ResponseEntity<?> findAllUser();
    ResponseEntity<?> updateProfileImg(RequestUserUpdateDto dto);
}
