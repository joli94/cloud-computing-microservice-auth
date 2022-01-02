package ro.unibuc.fmi.dietapp.microservice.authentication.exception;

import javax.naming.AuthenticationException;

public class JwtTokenMalformedException extends AuthenticationException {
    public JwtTokenMalformedException(String message) {
        super(message);
    }
}

