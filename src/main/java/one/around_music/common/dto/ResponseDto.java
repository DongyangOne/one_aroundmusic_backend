package one.around_music.common.dto;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;

@AllArgsConstructor
public class ResponseDto {
    private Integer code;
    private String message;

    public static ResponseDto of(Integer statusCode, String message) {
        return new ResponseDto(statusCode, message);
    }

}
