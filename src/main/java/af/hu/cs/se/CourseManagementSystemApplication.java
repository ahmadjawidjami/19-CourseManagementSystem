package af.hu.cs.se;

import af.hu.cs.se.model.*;
import af.hu.cs.se.repository.BookRepository;
import af.hu.cs.se.repository.CourseRepository;
import af.hu.cs.se.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class CourseManagementSystemApplication implements CommandLineRunner {

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private CourseRepository courseRepository;

    public static void main(String[] args) {
        SpringApplication.run(CourseManagementSystemApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        Student student = new Student();

        student.setFirstName("Jawid");
        student.setLastName("Jami");

        Course course = new Course();
        course.setCourseName("SE");

        CourseAttendance courseAttendance = new CourseAttendance();

        courseAttendance.setStudent(student);
        courseAttendance.setCourse(course);

        student.getCourseAttendances().add(courseAttendance);

        courseRepository.save(course);
        studentRepository.save(student);

    }
}
