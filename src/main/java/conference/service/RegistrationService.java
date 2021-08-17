package conference.service;

import conference.controller.api.RegistrationRequestDto;
import conference.db.UserEntity;
import conference.repositories.RoleRepository;
import conference.repositories.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class RegistrationService {
    private final PasswordEncoder passwordEncoder;
    private UserRepository userRepository;
    private RoleRepository roleRepository;

    public void register(RegistrationRequestDto request) {
        var user = new UserEntity();
        user.setPassword(passwordEncoder.encode(request.getPassword()));
        user.setUsername(request.getUsername());

        var listenerRole = roleRepository.getById(3L);
        var userRole = user.getRoles();
        userRole.add(listenerRole);

        var saved = userRepository.save(user);

        var a = userRepository.findAll().stream().findFirst().get(); //wtf?
        var b = a.getRoles().stream().findFirst().orElse(null);
        System.out.println();


    }
}
