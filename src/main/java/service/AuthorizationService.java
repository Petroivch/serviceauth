package service;

import enums.Authorities;
import exception.InvalidCredentials;
import exception.UnauthorizedUser;
import org.springframework.http.HttpStatus;
import repository.UserRepository;

import java.util.List;

public class AuthorizationService {
    UserRepository userRepository = new UserRepository();

    public List<Authorities> getAuthorities(String user, String password) {
        List<Authorities> userAuthorities = userRepository.getUserAuthorities(user);
        List<Authorities> userAuthoritiesPass = userRepository.getUserAuthoritiesPass(user, password);
        if (isEmpty(userAuthorities)) {
            throw new UnauthorizedUser("Unknown user " + user, HttpStatus.UNAUTHORIZED);
        }else{
            if (isEmpty(userAuthoritiesPass)) {
                throw new InvalidCredentials("Password is invalid", HttpStatus.BAD_REQUEST);
            }
        }
        return userAuthorities;
    }

    private boolean isEmpty(String str) {
        return str == null || str.isEmpty();
    }

    private boolean isEmpty(List<?> str) {
        return str == null || str.isEmpty();
    }
}