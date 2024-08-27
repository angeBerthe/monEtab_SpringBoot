package ci.digitalacademy.monetab.repositories;

import ci.digitalacademy.monetab.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

    User findByPseudoAndPassword(String pseudo, String password);
}
