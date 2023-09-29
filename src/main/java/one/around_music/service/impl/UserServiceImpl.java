package one.around_music.service.impl;

import lombok.RequiredArgsConstructor;
import one.around_music.common.dto.CommonResponse;
import one.around_music.common.dto.CustomException;
import one.around_music.common.util.SecurityUtil;
import one.around_music.config.jwt.JwtDto;
import one.around_music.config.jwt.JwtTokenProvider;
import one.around_music.config.jwt.UserAuthority;
import one.around_music.domain.User;
import one.around_music.dto.user.RequestUserLoginDto;
import one.around_music.dto.user.RequestUserSaveDto;
import one.around_music.dto.user.RequestUserUpdateDto;
import one.around_music.repository.reward.RewardJpaRepository;
import one.around_music.repository.user.UserJpaRepository;
import one.around_music.repository.userReward.UserRewardJpaRepositroy;
import one.around_music.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserJpaRepository userJpaRepository;
    private final JwtTokenProvider jwtTokenProvider;
    private final AuthenticationManagerBuilder authenticationManagerBuilder;
    private final PasswordEncoder passwordEncoder;

    @Override
    public ResponseEntity<?> saveUser(RequestUserSaveDto dto) {

        Optional<User> findUser = userJpaRepository.findByEmail(dto.getEmail());
        if(findUser.isPresent()) {
            throw new CustomException("이미 가입된 회원입니다.",  HttpStatus.BAD_REQUEST);
        }

        userJpaRepository.save(User.builder().email(dto.getEmail()).authority(UserAuthority.USER).socialToken(passwordEncoder.encode(dto.getSocialToken()))
                .nickname(dto.getNickname()).build());

        return CommonResponse.createResponse(HttpStatus.OK.value(), "회원가입에 성공했습니다.");
    }

    @Override
    public ResponseEntity<?> login(RequestUserLoginDto dto) {
        Optional<User> findUser = userJpaRepository.findByEmail(dto.getEmail());

        if(findUser.isEmpty()) {
            throw new CustomException("회원가입이 필요합니다.", HttpStatus.NOT_FOUND);
        }

        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(dto.getEmail(), dto.getSocialToken());
        Authentication authentication = authenticationManagerBuilder.getObject().authenticate(authenticationToken);
        SecurityContextHolder.getContext().setAuthentication(authentication);
        JwtDto jwtDto = jwtTokenProvider.generateToken(authentication);

        Map<String, String> response = new HashMap<>();
        response.put("access", jwtDto.getAccessToken());
        response.put("refresh", jwtDto.getRefreshToken());

        return CommonResponse.createResponse(HttpStatus.OK.value(), "로그인 성공.", response);
    }

    @Override
    public ResponseEntity<?> findAllUser() {
        return null;
    }

    @Override
    public ResponseEntity<?> updateProfileImg(RequestUserUpdateDto dto) {
        User findUser = SecurityUtil.getCurrentUserId(userJpaRepository);
        findUser.setProfileImg(dto.getProfileImg());
        userJpaRepository.save(findUser);
        return CommonResponse.createResponse(HttpStatus.OK.value(), "프로필 이미지 변경에 성공했습니다.");
    }
}
