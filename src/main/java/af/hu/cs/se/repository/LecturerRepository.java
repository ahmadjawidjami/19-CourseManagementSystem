package af.hu.cs.se.repository;

import af.hu.cs.se.model.Lecturer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LecturerRepository extends JpaRepository <Lecturer, Long> {
}
