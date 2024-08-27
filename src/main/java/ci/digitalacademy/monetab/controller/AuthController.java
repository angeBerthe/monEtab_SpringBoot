package ci.digitalacademy.monetab.controller;

import ci.digitalacademy.monetab.models.User;
import ci.digitalacademy.monetab.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequiredArgsConstructor
@RequestMapping
public class AuthController {

    private final UserService userService;

    @GetMapping
    public String showLogin(Model model){
        model.addAttribute("user", new User());
        return "auth/login";
    }

    @PostMapping
    public String login(@RequestParam String pseudo, @RequestParam String password, Model model) {
        User user = userService.findByPseudoAndPassword(pseudo, password);
        if (user == null) {
            model.addAttribute("error", "Pseudo ou mot de passe incorrect");
            return "auth/login";
        }
        return "redirect:/home";
    }
}
