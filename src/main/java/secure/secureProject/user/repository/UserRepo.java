package secure.secureProject.user.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import secure.secureProject.user.domain.User;

@Repository
public interface UserRepo extends JpaRepository<User, Long> {

}
