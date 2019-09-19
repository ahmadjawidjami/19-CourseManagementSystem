package af.hu.cs.se.service;

import af.hu.cs.se.model.Student;

import java.util.List;

public interface StudentService {
    void saveStudent(Student student);

    List<Student> findAll();

    Student findStudentById(Long id);

    void deleteStudentById(Long id);
}
