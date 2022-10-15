package controller;

import enums.Authorities;
import exception.InvalidCredentials;
import exception.UnauthorizedUser;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import service.AuthorizationService;

import java.util.List;

@RestController
public class AuthorizationController {
    AuthorizationService service = new AuthorizationService();

    @GetMapping(path = "/authorize")
    public List<Authorities> getAuthorities(@RequestParam("user") String user, @RequestParam("password") String password) {
        return service.getAuthorities(user, password);
    }
    @ExceptionHandler(InvalidCredentials.class)
    public ResponseEntity<String> invalidCredentials(InvalidCredentials exception) {
        String message = exception.getMessage();
        return new ResponseEntity<>(message, HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler(UnauthorizedUser.class)
    public ResponseEntity<String> mismatchException(UnauthorizedUser exception) {
        String message = exception.getMessage();
        System.out.println(message);
        return new ResponseEntity<>(message, HttpStatus.UNAUTHORIZED);
    }
}