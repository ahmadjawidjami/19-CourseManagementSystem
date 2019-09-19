package af.hu.cs.se.repository;

import af.hu.cs.se.model.Subject;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SubjectRepository extends JpaRepository <Subject, Long> {
}
