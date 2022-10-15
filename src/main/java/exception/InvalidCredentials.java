package exception;

import org.springframework.http.HttpStatus;

public class InvalidCredentials extends RuntimeException {
    public InvalidCredentials(String msg, HttpStatus status) {
        super(msg);
    }
}