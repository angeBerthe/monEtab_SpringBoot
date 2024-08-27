package ci.digitalacademy.monetab.services;

import ci.digitalacademy.monetab.models.User;

import java.util.List;
import java.util.Optional;

public interface UserService {

    User save(User user);

    User update(User user);

    Optional<User> findOne(Long id_user);

    List<User> findAll();

    void delete(Long id_user);

    User findByPseudoAndPassword(String pseudo, String password);
}
