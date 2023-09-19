package one.around_music.common.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ErrorCode {

    NOT_FOUND(404, "NOT FOUND", "NOT FOUND");

    private int status;
    private String errorCode;
    private String message;
}
