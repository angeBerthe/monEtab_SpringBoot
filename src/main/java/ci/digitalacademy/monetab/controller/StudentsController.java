package ci.digitalacademy.monetab.controller;

import ci.digitalacademy.monetab.models.Student;
import ci.digitalacademy.monetab.services.StudentService;
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

@Controller
@RequiredArgsConstructor
@Slf4j
@RequestMapping("/students")
public class StudentsController {

    private final StudentService studentService;

    @GetMapping("/add")
    public String showAddStudentPage(Model model){
        model.addAttribute("student", new Student());
        return "students/forms";
    }

    @PostMapping
    public String saveStudent(@RequestParam("dateDeNaissance") String dateDeNaissance, Student student){
        log.debug("Request to save student");
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        try {

            Date dateNaissance = formatter.parse(dateDeNaissance); // Format DD/MM/YYYY

            student.setDateDeNaissance(String.valueOf(dateNaissance));
        } catch (ParseException e) {
            e.printStackTrace();
}
        studentService.save(student);
        return "redirect:/students";
    }

    @GetMapping
    public String showStudentPage(Model model){
        log.debug("Request to show student");
        List<Student> students = studentService.findAll();
        model.addAttribute("students", students);
        return "students/list";
    }

    @GetMapping("/{id_person}")
    public String showUpdateStudentForms(@PathVariable Long id_person, Model model){
        log.debug("Request to show update student forms");
        Optional<Student> student = studentService.findOne(id_person);
        if (student.isPresent()){
            model.addAttribute("student", student.get());
            return "students/forms";
        }else {
            return "redirect:/students";
        }
    }

    @PostMapping("/{id_person}")
    public String deleteStudent(@PathVariable Long id_person) {
        studentService.delete(id_person);
        return "redirect:/students";
    }
}
