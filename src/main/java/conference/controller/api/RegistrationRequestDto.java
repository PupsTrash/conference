package conference.controller.api;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
public class RegistrationRequestDto {
    @Schema(example = "john333")
    private String username;

    @Schema(example = "qwer1234", description = "password will be encrypted by the server")
    private String password;
}
