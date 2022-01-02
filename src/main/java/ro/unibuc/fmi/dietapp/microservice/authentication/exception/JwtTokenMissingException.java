package ro.unibuc.fmi.dietapp.microservice.authentication.exception;

import javax.naming.AuthenticationException;

public class JwtTokenMissingException extends AuthenticationException {
    public JwtTokenMissingException(String message) {
        super(message);
    }
}
