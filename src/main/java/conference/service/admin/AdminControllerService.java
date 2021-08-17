package conference.service.admin;

import conference.controller.api.AdminDto;

import java.util.List;

/**
 * method's for admin controller service
 */
public interface AdminControllerService {

    AdminDto addUser(AdminDto user);

    List<AdminDto> getAllUsers();

    AdminDto editUser(AdminDto editData);

    void deleteUser(Long id);
}
