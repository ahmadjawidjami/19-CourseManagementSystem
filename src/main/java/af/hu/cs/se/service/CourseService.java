package af.hu.cs.se.service;

import af.hu.cs.se.model.Course;
import org.springframework.stereotype.Service;


public interface CourseService {

    Object findAll();

    Course findCourseById(Long id);

    void deleteCourseById(Long id);

    void saveCourse(Course course);
}
