package one.around_music.vo;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class FriendVo {

    private Long id;
    private Long friendId;
    private String nickname;
    private String profileImg;

}
