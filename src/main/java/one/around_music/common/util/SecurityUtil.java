package one.around_music.common.util;

import one.around_music.domain.User;
import one.around_music.repository.user.UserJpaRepository;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import java.util.Optional;

public class SecurityUtil {

    public static User getCurrentUserId(UserJpaRepository userJpaRepository) {
        final Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        if(authentication == null || authentication.getName() == null) {
            throw new RuntimeException("No Authentication information");
        }

        Optional<User> findUser = userJpaRepository.findByEmail(authentication.getName());

        if(findUser.isEmpty()){
            throw new RuntimeException("유저를 찾을 수 없습니다.");
        }
        return findUser.get();
    }

}
