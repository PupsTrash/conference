package conference.service.admin;

import conference.db.UserEntity;

import java.util.List;

public interface AdminControllerService {


    UserEntity addUser(UserEntity user);


    List<UserEntity> getAllUsers();


    UserEntity editUser(Long id, UserEntity editData);

    void deleteUser(Long id);
}
