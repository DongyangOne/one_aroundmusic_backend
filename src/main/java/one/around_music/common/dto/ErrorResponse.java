package one.around_music.common.dto;

import lombok.Data;
import org.springframework.http.HttpStatus;

@Data
public class ErrorResponse {

    private int status;
    private String message;

    public ErrorResponse(HttpStatus status, String message){
        this.status = status.value();
        this.message = message;
    }

}
