package ci.digitalacademy.monetab.controller;

import ci.digitalacademy.monetab.models.Student;
import ci.digitalacademy.monetab.models.Teacher;
import ci.digitalacademy.monetab.services.TeacherService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Controller
@Slf4j
@RequestMapping("/teachers")
public class TeachersController {
    private final TeacherService teacherService;


    @GetMapping("/add")
    public String showAddTeacherPage(Model model){
        model.addAttribute("teacher", new Teacher());
        return "teachers/forms";
    }

    @PostMapping
    public String saveTeacher(@RequestParam("dateDeNaissance") String dateDeNaissance, Teacher teacher){
        log.debug("Request to save teacher");
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        try {

            Date dateNaissance = formatter.parse(dateDeNaissance); // Format DD/MM/YYYY

            teacher.setDateDeNaissance(String.valueOf(dateNaissance));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        teacherService.save(teacher);
        return "redirect:/teachers";
    }

    @GetMapping
    public String showTeacherPage(Model model){
        List<Teacher> teachers = teacherService.findAll();
        model.addAttribute("teachers",teachers);
        return "teachers/list";
    }

    @GetMapping("/{id_person}")
    public String showUpdateTeacherForms(@PathVariable Long id_person, Model model){
        log.debug("Request to show update student forms");
        Optional<Teacher> teacher = teacherService.findOne(id_person);
        if (teacher.isPresent()){
            model.addAttribute("teacher", teacher.get());
            return "teachers/forms";
        }else {
            return "redirect:/teachers";
        }
    }

    @PostMapping("/{id_person}")
    public String deleteTeacher(@PathVariable Long id_person) {
        teacherService.delete(id_person);
        return "redirect:/teachers";
    }
}
