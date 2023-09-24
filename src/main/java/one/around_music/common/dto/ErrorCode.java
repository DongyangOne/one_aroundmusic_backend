package one.around_music.common.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ErrorCode {

    NOT_FOUND(404),
    BAD_REQUEST(400)
    ;

    private int status;
}
