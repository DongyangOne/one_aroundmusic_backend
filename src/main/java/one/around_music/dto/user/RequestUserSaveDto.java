package one.around_music.dto.user;

import lombok.Data;

@Data
public class RequestUserSaveDto {
    private String email;
    private String nickname;
    private char sex;
    private int age;
    private String password;
}
