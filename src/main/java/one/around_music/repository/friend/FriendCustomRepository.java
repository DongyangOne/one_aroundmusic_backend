package one.around_music.repository.friend;

import one.around_music.vo.FriendVo;
import one.around_music.vo.UserVo;

import java.util.List;

public interface FriendCustomRepository {

    List<FriendVo> findReciveInviteList(Long userId);
    List<FriendVo> findFriendList(Long userId);
    List<FriendVo> findSendInviteList(Long userId);
    List<UserVo> findAllUserExceptFriend(Long user_id);
}
