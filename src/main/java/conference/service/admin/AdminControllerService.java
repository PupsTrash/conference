package conference.service.admin;

import conference.controller.api.AdminDto;
import conference.db.UserEntity;

import java.util.List;

public interface AdminControllerService {

    AdminDto addUser(AdminDto user);


    List<AdminDto> getAllUsers();


    AdminDto editUser(AdminDto editData);

    void deleteUser(Long id);
}
