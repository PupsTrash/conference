package conference.service.admin;

import conference.db.UserEntity;
import conference.repositories.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class AdminControllerServiceImpl implements AdminControllerService {
    UserRepository userRepository;


    @Override
    public UserEntity addUser(UserEntity user) {
        return null;
    }

    @Override
    public List<UserEntity> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public UserEntity editUser(Long id, UserEntity editData) {
        var user = userRepository.findById(id).orElseThrow();
        user.setUsername(editData.getUsername());
        user.setPassword(editData.getPassword());
        user.setRoles(editData.getRoles());

        return userRepository.save(user);

    }

    @Override
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }
}
