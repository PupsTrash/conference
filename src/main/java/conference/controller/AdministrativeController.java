package conference.controller;

import conference.controller.api.RegistrationRequestDto;
import conference.service.RegistrationService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/registration")
@AllArgsConstructor
/**
 * simple controller for registration
 */
public class AdministrativeController {

    private RegistrationService service;

    @PostMapping("/register")
    public void register(@RequestBody RegistrationRequestDto request) {
        service.register(request);
    }
}
