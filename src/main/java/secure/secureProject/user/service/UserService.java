package secure.secureProject.user.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import secure.secureProject.user.domain.User;
import secure.secureProject.user.domain.dto.UserDto;
import secure.secureProject.user.domain.en.UserRole;
import secure.secureProject.user.repository.UserCrud;

import java.util.Objects;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserCrud userCrud;

    public User userRegister(String loginId, String password, String name, UserRole userRole){
        UserDto.UserValidation.UserValidationBuilder validation =
                UserDto.UserValidation.builder();

        if(loginId != null){
            validation.loginId(loginId);
        }
        if(password != null){
            validation.password(password);
        }
        if(name != null){
            validation.name(name);
        }

        if(userCrud.validation(validation.build())){
            return userCrud.save(new User(loginId, password, name, userRole));
        }else{
            return null;
        }
    }
}
