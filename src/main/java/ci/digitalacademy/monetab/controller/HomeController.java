package ci.digitalacademy.monetab.controller;

import ci.digitalacademy.monetab.services.StudentService;
import ci.digitalacademy.monetab.services.TeacherService;
import ci.digitalacademy.monetab.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping
public class HomeController {

    private StudentService studentService;
    private TeacherService teacherService;
    private UserService userService;
    @GetMapping("/home")
    public String showHomePage(){
        return "home/dashboad";
    }
}
