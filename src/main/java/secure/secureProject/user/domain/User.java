package secure.secureProject.user.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import secure.secureProject.user.domain.en.UserRole;

import javax.persistence.*;

@Entity
@AllArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "login_id")
    private String loginId;
    @Column(name = "password")
    private String password;
    @Column(name = "name")
    private String name;
    @Column(name = "user_role")
    private UserRole userRole;

    @Builder
    public User(
            String loginId,
            String password,
            String name,
            UserRole userRole){
        this.loginId = loginId;
        this.password = password;
        this.name = name;
        this.userRole = userRole;
    }


}
