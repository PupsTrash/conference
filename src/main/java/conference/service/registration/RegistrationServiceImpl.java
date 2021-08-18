package conference.service.registration;

import conference.controller.api.RegistrationRequestDto;
import conference.db.UserEntity;
import conference.repositories.RoleRepository;
import conference.repositories.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class RegistrationServiceImpl implements RegistrationService {
    private final PasswordEncoder passwordEncoder;
    private UserRepository userRepository;
    private RoleRepository roleRepository;

    @Override
    public void register(RegistrationRequestDto request) {
        var user = new UserEntity();
        user.setPassword(passwordEncoder.encode(request.getPassword()));
        user.setUsername(request.getUsername());

        var listenerRole = roleRepository.getById(3L);
        var userRole = user.getRoles();
        userRole.add(listenerRole);

        userRepository.save(user);
    }
}
