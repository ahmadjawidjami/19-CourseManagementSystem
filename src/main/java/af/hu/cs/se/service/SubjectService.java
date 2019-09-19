package af.hu.cs.se.service;

import af.hu.cs.se.model.Student;
import af.hu.cs.se.model.Subject;

import java.util.List;

public interface SubjectService {
    void saveSubject(Subject subject);

    List<Subject> findAll();

    Subject findSubjectById(Long id);

    void deleteSubjectById(Long id);
}
