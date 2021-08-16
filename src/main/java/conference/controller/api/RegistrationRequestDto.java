package conference.controller.api;

import lombok.Data;

@Data
public class RegistrationRequestDto {
    private String username;
    private String password;
//    private Role role;

//    enum Role {
//        SPEAKER,
//        LISTENER,
//    }
}
