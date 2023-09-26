package one.around_music.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import one.around_music.common.entity.BaseEntity;
import one.around_music.config.jwt.UserAuthority;

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

    @Column(name = "profileImg", length = 120)
    private String profileImg;

    @Column(name = "socialToken", length = 200, nullable = false)
    private String socialToken;

    @Column(nullable = false)
    private UserAuthority authority;

}
