package ro.unibuc.fmi.dietapp.microservice.authentication.model;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Login {
    private String username;
    private String password;
}
