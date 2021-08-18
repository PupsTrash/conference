package conference.controller;

import conference.controller.api.RegistrationRequestDto;
import conference.service.registration.RegistrationService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class AdministrativeControllerImpl implements AdministrativeControllerApi {
    private final RegistrationService service;


    @Override
    public void register(RegistrationRequestDto request) {
        service.register(request);
    }
}
