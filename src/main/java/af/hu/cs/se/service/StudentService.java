package af.hu.cs.se.service;

import af.hu.cs.se.model.Student;

public interface StudentService {
    void saveStudent(Student student);

    Object findAll();

    Student findStudentById(Long id);

    void deleteStudentById(Long id);
}
