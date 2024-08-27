package ci.digitalacademy.monetab.repositories;


import ci.digitalacademy.monetab.models.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeacherRepository extends JpaRepository<Teacher, Long> {
}
