package one.around_music.service.impl;

import lombok.RequiredArgsConstructor;
import one.around_music.common.dto.CommonResponse;
import one.around_music.config.jwt.JwtDto;
import one.around_music.config.jwt.JwtTokenProvider;
import one.around_music.config.jwt.UserAuthority;
import one.around_music.domain.User;
import one.around_music.dto.user.RequestUserLoginDto;
import one.around_music.dto.user.RequestUserSaveDto;
import one.around_music.repository.user.UserJpaRepository;
import one.around_music.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.core.Authentication;
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

        userJpaRepository.save(User.builder().email(dto.getEmail()).authority(UserAuthority.USER).password(passwordEncoder.encode(dto.getPassword()))
                .nickname(dto.getNickname()).age(dto.getAge()).sex(dto.getSex()).build());

        return CommonResponse.createResponse(HttpStatus.OK.value(), "회원가입에 성공했습니다.");
    }

    @Override
    public ResponseEntity<?> login(RequestUserLoginDto dto) {
        Optional<User> findUser = userJpaRepository.findByEmail(dto.getEmail());

        if(findUser.isEmpty()) {
            return CommonResponse.createResponse(HttpStatus.NOT_FOUND.value(), "유저를 찾을 수 없습니다.");
        }

        if(!passwordEncoder.matches(dto.getPassword(), findUser.get().getPassword())) {
            return CommonResponse.createResponse(HttpStatus.BAD_REQUEST.value(), "패스워드가 일치하지 않습니다.");
        }

        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(dto.getEmail(), dto.getPassword());
        Authentication authentication = authenticationManagerBuilder.getObject().authenticate(authenticationToken);

        JwtDto jwtDto = jwtTokenProvider.generateToken(authentication, findUser.get().getId());

        Map<String, String> response = new HashMap<>();
        response.put("access", jwtDto.getAccessToken());
        response.put("refresh", jwtDto.getRefreshToken());

        return CommonResponse.createResponse(HttpStatus.OK.value(), "로그인 성공.", response);
    }
}
