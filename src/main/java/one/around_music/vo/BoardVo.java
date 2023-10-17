package one.around_music.vo;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
public class BoardVo {

    private Long id;
    private UserVo user;
    private String content;
    private String location;
    private String img;
    private LocalDateTime createdDate;

}
