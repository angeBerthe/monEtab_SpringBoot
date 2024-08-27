package ci.digitalacademy.monetab.services.impl;

import ci.digitalacademy.monetab.models.User;
import ci.digitalacademy.monetab.repositories.UserRepository;
import ci.digitalacademy.monetab.services.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor //Permet de créer les constructeurs des propriétés requit
@Slf4j  //2eme manière de faire la journalisation
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    //private final Logger log = LoggerFactory.getLogger(UserServiceImpl.class);// 1ere manière de faire la journalisation
    @Override
    public User save(User user) {
        return userRepository.save(user);
    }

    //un bin est une clase jva sans paramètre
    @Override
    public User update(User user) {
        log.debug("Request to update {}", user);
        /* return findOne(user.getId())// fonction lambda permettant de modifier l''utilisateur
                .map(existngUser -> {//
                    existngUser.setPassword(user.getPassword());
                    existngUser.setPseudo(user.getPseudo());
                    return existngUser;
                }).map(existingUser -> {//Fonction lambda permettant d'enregistrer l'utilisateur dans la première map
                    return save(existingUser);
                }).orElseThrow(() -> new IllegalArgumentException();//Lever une exception existance de l'utilisateur
                */
        Optional<User> optionalUser = findOne(user.getId_user());// recuperation d'un optional<user>
        if (optionalUser.isPresent()) { // Vérification de l'existance d'un contenu par le optional
            User userToUpdate = optionalUser.get();//Déclaration + affectation d'un user à partir du optional
            userToUpdate.setPassword(user.getPassword());//mise à jour du mot de passe
            userToUpdate.setPseudo(user.getPseudo());//mise à jour du pseudo
            return save(userToUpdate);//Enregistrément de l'utilisateur modifié
        } else {
            throw new IllegalArgumentException();
        }
    }

    @Override
    public Optional<User> findOne(Long id_user) {
        log.debug("Request to update {}", id_user);
        return userRepository.findById(id_user);
    }

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public void delete(Long id_user) {
        log.debug("Request to update {}", id_user);
        userRepository.deleteById(id_user);
    }

    public User findByPseudoAndPassword(String pseudo, String password) {
        return userRepository.findByPseudoAndPassword(pseudo, password);
    }
}
