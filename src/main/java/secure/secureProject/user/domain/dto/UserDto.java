package secure.secureProject.user.domain.dto;

import lombok.Builder;
import lombok.Getter;

public class UserDto {


    @Getter
    public static class UserValidation{
        private String loginId;
        private String password;
        private String name;

        @Builder
        public UserValidation(String loginId, String password, String name){
            this.loginId = loginId;
            this.password = password;
            this.name = name;
        }
    }
}
