package secure.secureProject.user.repository;

import antlr.collections.List;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import secure.secureProject.user.domain.QUser;
import secure.secureProject.user.domain.User;
import secure.secureProject.user.domain.dto.UserDto;

@Service
@RequiredArgsConstructor
public class UserCrud{

    private UserRepo userRepo;
    private JPAQueryFactory factory;

    public User save(User user){
        return userRepo.save(user);
    }

    public boolean validation(UserDto.UserValidation userValidation){
        QUser qUser = QUser.user;

        if(userValidation.getLoginId() != null){
            long count = factory
                    .selectFrom(qUser)
                    .where(qUser.loginId.eq(userValidation.getLoginId())
                                    .or(qUser.password.eq(userValidation.getPassword()))
                                    .or(qUser.name.eq(userValidation.getName())))
                    .fetchCount();
            if(0<count){ return false; }
        }
        return true;
    }
}
