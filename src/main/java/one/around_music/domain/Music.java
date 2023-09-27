package one.around_music.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import one.around_music.common.entity.BaseEntity;

import javax.persistence.*;

@Entity
@Table(name = "tbl_music")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Music extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "youtube_id", nullable = false, length = 50)
    private String youtubId;

    @Column(name = "title", nullable = false, length = 50)
    private String title;

    @Column(name = "thumbnail", nullable = false, length = 100)
    private String thumbnail;

}
