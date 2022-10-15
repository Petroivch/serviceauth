package exception;

import org.springframework.http.HttpStatus;

public class UnauthorizedUser extends RuntimeException {
    public UnauthorizedUser(String msg, HttpStatus badRequest) {
        super(msg);
    }
}