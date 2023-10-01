package one.around_music.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import one.around_music.domain.Music;

@Data
@AllArgsConstructor
public class ArVo {
    private Long id;
    private MusicVo music;
    private String reward;
    private double latitude;
    private double longitude;
}
