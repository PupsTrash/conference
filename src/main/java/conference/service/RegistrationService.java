package conference.service;

import conference.controller.api.RegistrationRequestDto;
import conference.db.RoleEntity;
import conference.db.UserEntity;
import conference.db.UserRoleEntity;
import conference.repositories.RoleRepository;
import conference.repositories.UserRepository;
import conference.repositories.UserRoleRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class RegistrationService {
    private UserRepository userRepository;
    private RoleRepository roleRepository;
    private UserRoleRepository userRoleRepository;

    public void register(RegistrationRequestDto request) {
        var user = new UserEntity();
        user.setPassword(request.getPassword());
        user.setUsername(request.getUsername());

        var role = roleRepository.getById(3L);
        var roles2 = user.getRoles();
        roles2.add(role);

        var saved = userRepository.save(user);

//
//        var roles = saved.getRoles();
//        var userRoleEntity = new UserRoleEntity();
//        userRoleEntity.setRole(role);
//        userRoleEntity.setUser(saved);
//        var userrorle = userRoleRepository.save(userRoleEntity);

//        roles.add(userrorle);
//        var saved2 = userRepository.save(saved);
        var a = userRepository.findAll().stream().findFirst().get();
        var b = a.getRoles().stream().findFirst().orElse(null);
        System.out.println();


    }
}
