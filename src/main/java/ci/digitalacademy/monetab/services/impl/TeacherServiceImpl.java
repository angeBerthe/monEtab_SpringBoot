package ci.digitalacademy.monetab.services.impl;

import ci.digitalacademy.monetab.models.Teacher;
import ci.digitalacademy.monetab.models.User;
import ci.digitalacademy.monetab.repositories.TeacherRepository;
import ci.digitalacademy.monetab.services.TeacherService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TeacherServiceImpl implements TeacherService {

    private final TeacherRepository teacherRepository;

    @Override
    public Teacher save(Teacher teacher) {
        return teacherRepository.save(teacher);
    }

    @Override
    public Teacher update(Teacher teacher) {
            return teacherRepository.save(teacher);

    }

    @Override
    public Optional<Teacher> findOne(Long id_teacher) {
        return teacherRepository.findById(id_teacher);
    }

    @Override
    public List<Teacher> findAll() {
        return teacherRepository.findAll();
    }

    @Override
    public void delete(Long id_teacher) {
        teacherRepository.deleteById(id_teacher);
    }
}
