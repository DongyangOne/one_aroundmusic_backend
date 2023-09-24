package one.around_music.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import one.around_music.common.entity.BaseEntity;
import org.hibernate.annotations.Comment;

import javax.persistence.*;

@Entity
@Table(name = "tbl_friend")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Friend extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    @Comment("유저")
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "friend_id")
    @Comment("친구")
    private User friend;

    @Column(columnDefinition = "CHAR(1)", nullable = false)
    @Comment("친구 상태")
    private String status;

    public void setStatus(String status) {
        this.status = status;
    }
}
