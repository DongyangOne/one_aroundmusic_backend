package one.around_music.service;

import one.around_music.dto.friend.RequestFriendSaveDto;
import one.around_music.dto.friend.RequestInviteUpdateDto;
import org.springframework.http.ResponseEntity;

public interface FriendService {

    ResponseEntity<?> addFriend(RequestFriendSaveDto dto);
    ResponseEntity<?> deleteFriend(Long id);
    ResponseEntity<?> findAllReciveInvite();
    ResponseEntity<?> findAllSendInvite();
    ResponseEntity<?> updateInvite(RequestInviteUpdateDto dto);
    ResponseEntity<?> findAllFriends();
}
