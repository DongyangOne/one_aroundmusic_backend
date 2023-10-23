package one.around_music.vo;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class MusicVo {
    private Long id;
    private String youtubeId;
    private String title;
    private String thumbnail;
    private String href;
    private String singer;
}
