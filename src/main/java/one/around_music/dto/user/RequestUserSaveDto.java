package one.around_music.dto.user;

import lombok.Data;

@Data
public class RequestUserSaveDto {
    private String email;
    private String nickname;
    private String socialToken;
}
