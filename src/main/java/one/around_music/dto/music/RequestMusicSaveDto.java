package one.around_music.dto.music;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class RequestMusicSaveDto {
    @Schema(example = "string")
    private String youtubeId;

    @Schema(example = "title")
    private String title;

    @Schema(example = "/thumb/default.png")
    private String thumbnail;

    @Schema(example = "https://p.scdn.co/mp3-preview/c7317d8cd93e2e37901d3e9a91defb60817a022e?cid=e58220cc9b0e4832aac9f6b7d6c3bf5c")
    private String href;

    @Schema(example = "singer")
    private String singer;

}
