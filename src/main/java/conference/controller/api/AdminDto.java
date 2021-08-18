package conference.controller.api;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.util.Set;

@Data
public class AdminDto {


    private Long id;

    @Schema(example = "john333")
    private String username;

    @Schema(example = "qwer1234", description = "password will be encrypted by the server")
    private String password;

    @Schema(example = "[{LISTENER, SPEAKER}]")
    private Set<String> role;
}
