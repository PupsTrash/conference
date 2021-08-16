package conference.controller.api;

import lombok.Data;

import java.util.Set;

@Data
public class AdminDto {

    private Long id;

    private String username;

    private String password;

    private Set<String> role;
}
