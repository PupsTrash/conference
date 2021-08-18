package conference.service.registration;

import conference.controller.api.RegistrationRequestDto;

/**
 * main method`s Registration Service for Registration controller
 */
public interface RegistrationService {

    void register(RegistrationRequestDto request);
}
