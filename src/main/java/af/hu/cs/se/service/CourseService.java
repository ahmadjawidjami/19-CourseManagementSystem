package af.hu.cs.se.service;

import af.hu.cs.se.model.Course;
import org.springframework.stereotype.Service;

import java.util.List;


public interface CourseService {

    List<Course> findAll();

    Course findCourseById(Long id);

    void deleteCourseById(Long id);

    void saveCourse(Course course);
}
