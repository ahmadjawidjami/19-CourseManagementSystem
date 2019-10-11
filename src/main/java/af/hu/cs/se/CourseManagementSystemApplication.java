package af.hu.cs.se;

import af.hu.cs.se.model.*;
import af.hu.cs.se.repository.BookRepository;
import af.hu.cs.se.repository.CourseAttendanceRepository;
import af.hu.cs.se.repository.CourseRepository;
import af.hu.cs.se.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;


@SpringBootApplication
public class CourseManagementSystemApplication implements CommandLineRunner {

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private CourseRepository courseRepository;

    @Autowired
    private CourseAttendanceRepository courseAttendanceRepository;

    public static void main(String[] args) {
        SpringApplication.run(CourseManagementSystemApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

    }
}
