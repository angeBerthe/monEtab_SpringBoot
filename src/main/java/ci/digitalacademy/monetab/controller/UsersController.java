package ci.digitalacademy.monetab.controller;

import ci.digitalacademy.monetab.models.Teacher;
import ci.digitalacademy.monetab.models.User;
import ci.digitalacademy.monetab.repositories.UserRepository;
import ci.digitalacademy.monetab.services.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.time.Instant;
import java.util.List;
import java.util.Optional;

@Controller
@RequiredArgsConstructor
@Slf4j
@RequestMapping("/users")
public class UsersController {

    private final UserService userService;

    @GetMapping("/add")
    public String showAddUserPage(Model model){
        model.addAttribute("user", new User());
        return "users/forms";
    }

    @PostMapping
    public String saveUser(User user){
        log.debug("Request to show save user");
        if (user.getCreationDate() == null) {
            user.setCreationDate(Instant.now());
        }
        userService.save(user);
        return "redirect:/users";
    }
    @GetMapping
    public String showUserPage(Model model){
        List<User> users = userService.findAll();
        model.addAttribute("users", users);
        return "users/list";
    }

    @GetMapping("/{id_user}")
    public String showUpdateTeacherForms(@PathVariable Long id_user, Model model){
        log.debug("Request to show update user forms");
        Optional<User> user = userService.findOne(id_user);
        if (user.isPresent()){
            model.addAttribute("user", user.get());
            return "users/forms";
        }else {
            return "redirect:/users";
        }
    }

    @PostMapping("/{id_user}")
    public String deleteUser(@PathVariable Long id_user) {
        userService.delete(id_user);
        return "redirect:/users";
    }
}
