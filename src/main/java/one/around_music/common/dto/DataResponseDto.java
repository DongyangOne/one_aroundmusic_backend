package one.around_music.common.dto;

import lombok.Getter;

@Getter
public class DataResponseDto<T> extends ResponseDto{

    private T data;

    public DataResponseDto(Integer code, String message, T data) {
        super(code, message);
        this.data = data;
    }

}
