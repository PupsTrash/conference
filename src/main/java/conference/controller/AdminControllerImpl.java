package conference.controller;

import conference.db.UserEntity;
import conference.service.admin.AdminControllerService;
import lombok.AllArgsConstructor;
import org.apache.catalina.User;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
public class AdminControllerImpl implements AdminControllerApi {
    AdminControllerService service;


    @Override
    public UserEntity addUser(UserEntity user) {
        return service.addUser(user);
    }

    @Override
    public List<UserEntity> getAllUsers() {
        return service.getAllUsers();
    }

    @Override
    public UserEntity editUser(Long id, UserEntity editData) {
        return service.editUser(id, editData);
    }

    @Override
    public void deleteUser(Long id) {
service.deleteUser(id);
    }
}
