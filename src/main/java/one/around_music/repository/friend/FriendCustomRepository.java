package one.around_music.repository.friend;

import one.around_music.vo.FriendVo;

import java.util.List;

public interface FriendCustomRepository {

    List<FriendVo> findReciveInviteList(Long userId);
    List<FriendVo> findFriendList(Long userId);
}
