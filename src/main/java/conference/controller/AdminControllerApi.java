package conference.controller;

import conference.controller.api.AdminDto;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * this controller allows you to update, change user data and add or delete user
 */

@Tag(name = "admin controller", description = "Common logic with admin for user management.")
@RequestMapping("/admin")
public interface AdminControllerApi {

    @PostMapping
    AdminDto addUser(@RequestBody AdminDto user);

    @GetMapping
    List<AdminDto> getAllUsers();

    @PutMapping
    AdminDto editUser(@RequestBody AdminDto editData);

    @DeleteMapping
    void deleteUser(@RequestBody AdminDto request);
}
