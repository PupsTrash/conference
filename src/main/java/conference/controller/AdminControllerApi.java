package conference.controller;

import conference.controller.api.AdminDto;
import conference.db.UserEntity;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@Tag(name = "admin controller", description = "Common logic with admin for management users.")
@RequestMapping("/admin")
public interface AdminControllerApi {

    @PostMapping
    AdminDto addUser(@RequestBody AdminDto user);

    @GetMapping
    List<AdminDto> getAllUsers();

    @PutMapping
    AdminDto editUser(@RequestBody AdminDto editData);

    @DeleteMapping
    void deleteUser(@RequestParam Long id);
}
