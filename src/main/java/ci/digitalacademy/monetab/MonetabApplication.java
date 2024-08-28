package ci.digitalacademy.monetab;

import ci.digitalacademy.monetab.models.*;
import ci.digitalacademy.monetab.services.*;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.sql.Date;
import java.time.Instant;
import java.util.*;

@SpringBootApplication
@AllArgsConstructor
public class MonetabApplication implements CommandLineRunner {

    private UserService userService;

    private NoteFileService noteFileService;

    private StudentService studentService;

    private TeacherService teacherService;

    private AddressService addressService;

    public static void main(String[] args) {
        SpringApplication.run(MonetabApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {


/*
        Teacher teacher = new Teacher();
        teacher.setVacant(true);
        teacher.setMatiereEnseigne("java");
        teacher.setProchainCours("python");
        teacher.setSujetProchaineReunion("Devoir");
        teacherService.save(teacher);


        NoteFile noteFile1 = new NoteFile();
        noteFile1.setNote("12");
        noteFile1.setAnnee("2023");
        NoteFile noteFile2 = new NoteFile();
        noteFile2.setNote("16");
        noteFile2.setAnnee("2024");
        noteFile1.setTeacher(teacher);
        noteFile2.setTeacher(teacher);
        noteFileService.save(noteFile1);
        noteFileService.save(noteFile2);


        List<Teacher> teachers = teacherService.findAll();
        System.out.println(teachers);

        Set<NoteFile> noteFiles = teachers.get(0).getNoteFiles();
        System.out.println(noteFiles);


*/

        //Enregistrement d'un élève
        /*Student student = new Student();
        student.setMatricule("123456S");
        student.setClasse("licence1");
        student.setEmail("koako@gmail.com");
        student.setLastName("kouakou");
        student.setFirstName("koako");

        Student student1 = new Student();
        student1.setMatricule("123456D");
        student1.setClasse("licence3");
        student1.setEmail("kouassi@gmail.com");
        student1.setLastName("amani");
        student1.setFirstName("kouassi");

        studentService.save(student);
        studentService.save(student1);

        //Enregistrement d'un professeur

        Teacher teacher = new Teacher();

        teacher.setLastName("Digbe");
        teacher.setFirstName("Henri");
        teacher.setEmail("digbehenri@gmail.com");
        teacher.setMatiereEnseigne("math");
        teacher.setVacant(true);
        teacher.setProchainCours("physique");
        teacher.setSujetProchaineReunion("conseil");

        Teacher teacher1 = new Teacher();

        teacher1.setLastName("Doumbia");
        teacher1.setFirstName("idriss");
        teacher1.setEmail("doumbiaidriss@gmail.com");
        teacher1.setMatiereEnseigne("français");
        teacher1.setVacant(true);
        teacher1.setProchainCours("histoire");
        teacher1.setSujetProchaineReunion("importance de phsique");

        teacherService.save(teacher);
        teacherService.save(teacher1);
*/
        //Enregistrement de l'utilisateur

/*
        User user = new User();

        user.setPseudo("angeB");
        user.setPassword("angeB123");
        user.setCreationDate(Instant.now());

        User user1 = new User();

        user1.setPseudo("angeS");
        user1.setPassword("angeS123");
        user1.setCreationDate(Instant.now());

        userService.save(user);
        userService.save(user1);

*/
    }

}
