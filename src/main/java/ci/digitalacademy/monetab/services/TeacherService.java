package ci.digitalacademy.monetab.services;

import ci.digitalacademy.monetab.models.Teacher;
import ci.digitalacademy.monetab.models.User;

import java.util.List;
import java.util.Optional;

public interface TeacherService {

    Teacher save(Teacher teacher);

    Teacher update(Teacher teacher);

    Optional<Teacher> findOne(Long id_teacher);

    List<Teacher> findAll();

    void delete(Long id_teacher);
}
