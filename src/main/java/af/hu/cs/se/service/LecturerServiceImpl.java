package af.hu.cs.se.service;

import af.hu.cs.se.model.Lecturer;
import af.hu.cs.se.repository.LecturerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LecturerServiceImpl implements LecturerService {

    @Autowired
    private LecturerRepository lecturerRepository;

    @Override
    public void saveLecturer(Lecturer lecturer) {
        lecturerRepository.save(lecturer);
    }

    @Override
    public List<Lecturer> findAll() {
        return lecturerRepository.findAll();
    }

    @Override
    public Lecturer findLecturerById(Long id) {
        return lecturerRepository.getOne(id);
    }

    @Override
    public void deleteLecturerById(Long id) {
        lecturerRepository.deleteById(id);
    }
}
