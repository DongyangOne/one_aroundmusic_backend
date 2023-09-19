package one.around_music.common.dto;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class CommonResponse {

    public static ResponseEntity<?> createResponse(int statusCode, String message, Object data) {
        return new ResponseEntity<>(new DataResponseDto<>(statusCode, message, data), HttpStatus.OK);
    }

    public static ResponseEntity<?> createResponse(int statusCode, String message) {
        return new ResponseEntity<>(new ResponseDto(statusCode, message), HttpStatus.OK);
    }

}
