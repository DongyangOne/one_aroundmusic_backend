package one.around_music.vo;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UserVo {

    private Long id;
    private String nickname;
    private String profileImg;

}
