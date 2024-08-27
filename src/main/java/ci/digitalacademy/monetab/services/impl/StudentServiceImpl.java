package ci.digitalacademy.monetab.services.impl;

import ci.digitalacademy.monetab.models.Student;
import ci.digitalacademy.monetab.models.User;
import ci.digitalacademy.monetab.repositories.StudentRepository;
import ci.digitalacademy.monetab.services.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;

    @Override
    public Student save(Student student) {
        return studentRepository.save(student);
    }

    @Override
    public Student update(Student student) {
            return studentRepository.save(student);

    }

    @Override
    public Optional<Student> findOne(Long id_student) {
        return studentRepository.findById(id_student);
    }

    @Override
    public List<Student> findAll() {
        return studentRepository.findAll();
    }

    @Override
    public void delete(Long id_person) {
        studentRepository.deleteById(id_person);
    }
}
