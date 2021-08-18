package conference.service.admin;

import conference.controller.api.AdminDto;
import conference.db.RoleEntity;
import conference.db.UserEntity;
import conference.repositories.RoleRepository;
import conference.repositories.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class AdminControllerServiceImpl implements AdminControllerService {
    private final UserRepository userRepository;
    private final AdminControllerServiceMapper mapper;
    private final RoleRepository roleRepository;
    private final PasswordEncoder encoder;

    @Override
    public AdminDto addUser(AdminDto request) {
        var user = new UserEntity();
        user.setRoles(getValidRoleSet(request));
        user.setUsername(request.getUsername());
        user.setPassword(encoder.encode(request.getPassword()));

        return mapper.toResponse(userRepository.save(user));
    }

    @Override
    public List<AdminDto> getAllUsers() {

        return mapper.toResponse(userRepository.findAll());
    }


    @Override
    public AdminDto editUser(AdminDto editData) {
        var user = userRepository.findById(editData.getId()).orElseThrow();
        user.setRoles(getValidRoleSet(editData));
        user.setUsername(editData.getUsername());
        user.setPassword(encoder.encode(editData.getPassword()));

        return mapper.toResponse(userRepository.save(user));
    }


    @Override
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }

    private Set<RoleEntity> getValidRoleSet(AdminDto editData) {
        var listRoles = roleRepository.findAll();
        var correctRoleName = listRoles.stream().map(p -> p.getHkey()).collect(Collectors.toSet());
        correctRoleName.retainAll(editData.getRole());
        var roleEntities = listRoles.stream()
                .filter(p -> correctRoleName.contains(p.getHkey()))
                .collect(Collectors.toSet());

        return roleEntities;
    }
}