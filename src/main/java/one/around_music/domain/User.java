package one.around_music.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import one.around_music.common.entity.BaseEntity;
import one.around_music.config.jwt.UserAuthority;
import org.hibernate.annotations.ColumnDefault;

import javax.persistence.*;

@Entity
@Table(name = "tbl_user")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false, length = 50)
    private String email;

    @Column(name = "nickname", length = 20, nullable = false)
    private String nickname;

    @Column(name = "profileImg", length = 300)
    @ColumnDefault("https://firebasestorage.googleapis.com/v0/b/aroundmusic.appspot.com/o/profile%2Fdefault.png?alt=media&token=ec855454-c305-499c-9b7b-adc3736484be")
    private String profileImg;

    @Column(name = "socialToken", length = 200, nullable = false)
    private String socialToken;

    @Column(nullable = false)
    private UserAuthority authority;

    public void setProfileImg(String profileImg) {
        this.profileImg = profileImg;
    }
}
