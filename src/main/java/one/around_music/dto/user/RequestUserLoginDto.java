package one.around_music.dto.user;

import lombok.Data;

@Data
public class RequestUserLoginDto {
    private String username;
    private String password;
}
