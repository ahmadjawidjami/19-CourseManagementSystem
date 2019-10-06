package af.hu.cs.se.repository;

import af.hu.cs.se.model.CourseAttendance;
import af.hu.cs.se.model.CourseAttendanceKey;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseAttendanceRepository extends JpaRepository<CourseAttendance, Long> {
}
