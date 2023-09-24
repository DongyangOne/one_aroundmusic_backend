package one.around_music.dto.user;

import lombok.Data;

@Data
public class RequestUserLoginDto {
    private String email;
    private String password;
}
