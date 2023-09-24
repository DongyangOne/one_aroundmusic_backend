package one.around_music.common.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@AllArgsConstructor
@Getter
public class ResponseDto {
    private Integer code;
    private String message;
}
