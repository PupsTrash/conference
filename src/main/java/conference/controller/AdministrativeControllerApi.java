package conference.controller;

import conference.controller.api.RegistrationRequestDto;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * simple controller for registration
 */
@Tag(name = "registration controller")
@RequestMapping("/api/v1/registration")
public interface AdministrativeControllerApi {

    @PostMapping("/register")
    void register(@RequestBody RegistrationRequestDto request);
}
