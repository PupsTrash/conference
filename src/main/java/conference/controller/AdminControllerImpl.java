package conference.controller;

import conference.controller.api.AdminDto;
import conference.service.admin.AdminControllerService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
public class AdminControllerImpl implements AdminControllerApi {
    private final AdminControllerService service;


    @Override
    public AdminDto addUser(AdminDto user) {
        return service.addUser(user);
    }

    @Override
    public List<AdminDto> getAllUsers() {
        return service.getAllUsers();
    }

    @Override
    public AdminDto editUser(AdminDto editData) {
        return service.editUser(editData);
    }

    @Override
    public void deleteUser(AdminDto request) {
        service.deleteUser(request.getId());
    }
}
