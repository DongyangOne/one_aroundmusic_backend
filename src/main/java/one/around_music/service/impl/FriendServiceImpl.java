package one.around_music.service.impl;

import lombok.RequiredArgsConstructor;
import one.around_music.common.dto.CommonResponse;
import one.around_music.common.dto.CustomException;
import one.around_music.common.util.SecurityUtil;
import one.around_music.domain.Friend;
import one.around_music.domain.User;
import one.around_music.dto.friend.RequestFriendSaveDto;
import one.around_music.dto.friend.RequestInviteUpdateDto;
import one.around_music.repository.friend.FriendJpaRepository;
import one.around_music.repository.user.UserJpaRepository;
import one.around_music.service.FriendService;
import one.around_music.vo.FriendVo;
import one.around_music.vo.UserVo;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class FriendServiceImpl implements FriendService{

    private final FriendJpaRepository friendJpaRepository;
    private final UserJpaRepository userJpaRepository;

    @Override
    public ResponseEntity<?> addFriend(RequestFriendSaveDto dto) {

        User findUser = SecurityUtil.getCurrentUserId(userJpaRepository);

        Optional<User> findFriend = userJpaRepository.findById(dto.getFirendId());

        if(findFriend.isEmpty()) {
            throw new CustomException("대상 유저를 찾을 수 없습니다.", HttpStatus.NOT_FOUND);
        }

        if(findFriend.get().getEmail().equals(findUser.getEmail())) {
            throw new CustomException("본인에게는 친구 요청을 할 수 없습니다.", HttpStatus.BAD_REQUEST);
        }

        Optional<Friend> addFriend = friendJpaRepository.findByUserAndFriend(findUser, findFriend.get());

        if(addFriend.isPresent()) {
            if(addFriend.get().getStatus().equals("Y")) {
                throw new CustomException("이미 친구 요청을 보냈습니다.", HttpStatus.BAD_REQUEST);
            }
            throw new CustomException("이미 친구 입니다.", HttpStatus.BAD_REQUEST);
        }

        friendJpaRepository.save(Friend.builder().friend(findFriend.get()).user(findUser).status("N").build());

        return CommonResponse.createResponse(HttpStatus.OK.value(), "친구 요청 보내기에 성공했습니다.");
    }

    @Override
    public ResponseEntity<?> deleteFriend(Long id) {

        User findUser = SecurityUtil.getCurrentUserId(userJpaRepository);

        Optional<Friend> findFriend = friendJpaRepository.findById(id);

        if(findFriend.isEmpty()) {
            throw new CustomException("친구 관계가 존재하지 않습니다.", HttpStatus.NOT_FOUND);
        }

        if(!findFriend.get().getFriend().equals(findUser) || !findFriend.get().getFriend().equals(findUser)) {
            throw new CustomException("본인과 관련된 친구관계가 아닙니다.", HttpStatus.BAD_REQUEST);
        }

        if(!findFriend.get().getStatus().equals("N")) {
            throw new CustomException("아직 친구 관계가 아닙니다.", HttpStatus.BAD_REQUEST);
        }

        friendJpaRepository.delete(findFriend.get());

        return CommonResponse.createResponse(HttpStatus.OK.value(), "친구 삭제에 성공했습니다.");
    }

    @Override
    public ResponseEntity<?> findAllReciveInvite() {

        User findUser = SecurityUtil.getCurrentUserId(userJpaRepository);

        List<FriendVo> findInviteList = friendJpaRepository.findReciveInviteList(findUser.getId());

        return CommonResponse.createResponse(HttpStatus.NO_CONTENT.value(), "받은 친구 요청 목록을 조회합니다.", findInviteList);
    }

    @Override
    public ResponseEntity<?> findAllSendInvite() {

        User findUser = SecurityUtil.getCurrentUserId(userJpaRepository);

        List<FriendVo> findInviteList = friendJpaRepository.findSendInviteList(findUser.getId());

        return CommonResponse.createResponse(HttpStatus.NO_CONTENT.value(), "보낸 친구 요청 목록을 조회합니다.", findInviteList);
    }

    @Override
    public ResponseEntity<?> updateInvite(RequestInviteUpdateDto dto) {

        Optional<Friend> findInvite = friendJpaRepository.findById(dto.getId());

        if(findInvite.isEmpty()) {
            throw new CustomException("친구 요청을 찾을 수 없습니다.", HttpStatus.NOT_FOUND);
        }

        if(findInvite.get().getStatus().equals("Y")) {
            throw new CustomException("이미 수락된 친구 요청입니다.", HttpStatus.BAD_REQUEST);
        }

        if(dto.getAccept().equals("Y")) {
            findInvite.get().setStatus(dto.getAccept());
            friendJpaRepository.save(findInvite.get());
        }

        if(dto.getAccept().equals("N")) {
            friendJpaRepository.delete(findInvite.get());
        }

        throw new CustomException("잘못된 요청입니다.", HttpStatus.BAD_REQUEST);
    }

    @Override
    public ResponseEntity<?> findAllFriends() {
        User findUser = SecurityUtil.getCurrentUserId(userJpaRepository);

        List<FriendVo> findFiendList = friendJpaRepository.findFriendList(findUser.getId());

        return CommonResponse.createResponse(HttpStatus.OK.value(), "친구 목록을 조회합니다.", findFiendList);
    }

    @Override
    public ResponseEntity<?> findAllUserExceptFriends() {
        User findUser = SecurityUtil.getCurrentUserId(userJpaRepository);
        List<UserVo> users = friendJpaRepository.findAllUserExceptFriend(findUser.getId());
        return CommonResponse.createResponse(HttpStatus.OK.value(), "유저 목록을 조회합니다.", users);
    }

}
