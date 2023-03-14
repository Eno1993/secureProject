package secure.secureProject.user.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import secure.secureProject.user.domain.User;
import secure.secureProject.user.domain.en.UserRole;
import secure.secureProject.user.service.UserService;

@RestController(value = "/user")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping("/register")
    public User userRegister(@RequestParam(name = "loginId") String loginId,
                             @RequestParam(name = "password") String password,
                             @RequestParam(name = "name") String name,
                             @RequestParam(name = "role") UserRole userRole){
        return userService.userRegister(loginId, password, name, userRole);

    }
}
