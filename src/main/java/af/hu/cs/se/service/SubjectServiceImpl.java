package af.hu.cs.se.service;

import af.hu.cs.se.model.Subject;
import af.hu.cs.se.repository.SubjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SubjectServiceImpl implements SubjectService {

    @Autowired
    private SubjectRepository subjectRepository;
    @Override
    public void saveSubject(Subject subject) {
        subjectRepository.save(subject);
    }

    @Override
    public List<Subject> findAll() {
        return subjectRepository.findAll();
    }

    @Override
    public Subject findSubjectById(Long id) {
        return subjectRepository.getOne(id);
    }

    @Override
    public void deleteSubjectById(Long id) {
        subjectRepository.deleteById(id);
    }
}
