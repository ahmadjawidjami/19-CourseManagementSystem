package af.hu.cs.se.service;

import af.hu.cs.se.model.Course;
import af.hu.cs.se.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseServiceImpl implements CourseService {

    @Autowired
    private CourseRepository courseRepository;


    @Override
    public List<Course> findAll() {
        return courseRepository.findAll();
    }

    @Override
    public Course findCourseById(Long id) {
        return courseRepository.getOne(id);
    }

    @Override
    public void deleteCourseById(Long id) {
        courseRepository.deleteById(id);
    }

    @Override
    public void saveCourse(Course course) {
        courseRepository.save(course);
    }
}
