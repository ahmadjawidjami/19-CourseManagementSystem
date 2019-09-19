package af.hu.cs.se.service;

import af.hu.cs.se.model.Lecturer;
import af.hu.cs.se.model.Subject;

import java.util.List;

public interface LecturerService {

    void saveLecturer(Lecturer lecturer);

    List<Lecturer> findAll();

    Lecturer findLecturerById(Long id);

    void deleteLecturerById(Long id);
}
