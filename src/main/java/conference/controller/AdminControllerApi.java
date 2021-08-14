package conference.controller;

import conference.db.UserEntity;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@Tag(name = "admin controller", description = "Common logic with admin for management users.")
@RequestMapping("/admin")
public interface AdminControllerApi {

    @PostMapping
    UserEntity addUser(UserEntity user);

    @GetMapping
    List<UserEntity> getAllUsers();

    @PutMapping
    UserEntity editUser(Long id, UserEntity editData);

    @DeleteMapping
    void deleteUser(Long id);
}
