package ro.unibuc.fmi.dietapp.microservice.authentication.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.*;
import ro.unibuc.fmi.dietapp.microservice.authentication.dto.LoginDto;
import ro.unibuc.fmi.dietapp.microservice.authentication.mapper.LoginMapper;
import ro.unibuc.fmi.dietapp.microservice.authentication.utils.JwtUtil;

@RestController
@RequestMapping("/auth")
public class AuthenticationController {
    private final LoginMapper mapper;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtUtil jwtUtil;

    public AuthenticationController(LoginMapper mapper) {
        this.mapper = mapper;
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody LoginDto loginDto) throws Exception{
        try{
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(mapper.toEntity(loginDto).getUsername(), mapper.toEntity(loginDto).getPassword())
            );
        } catch (BadCredentialsException ex) {
            throw new Exception("Incorrect username or password", ex);
        }

        final String token = jwtUtil.generateToken(mapper.toEntity(loginDto));

        return new ResponseEntity<>(token, HttpStatus.OK);
    }
}
