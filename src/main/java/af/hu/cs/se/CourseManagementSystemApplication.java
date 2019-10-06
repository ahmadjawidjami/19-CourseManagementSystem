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

//        CourseAttendanceKey courseAttendanceKey = new CourseAttendanceKey();
//        courseAttendanceKey.setStudentId(Long.valueOf(1));
//        courseAttendanceKey.setCourseId(Long.valueOf(1));
//
//        CourseAttendance courseAttendance = new CourseAttendance();
//
//        courseAttendance.setId(courseAttendanceKey);
//        courseAttendance.setRegistrationDate(Calendar.getInstance().getTime());
//
//        courseAttendanceRepository.save(courseAttendance);

//        Hobby hobby1 = new Hobby();
//        Hobby hobby2 = new Hobby();
//        Hobby hobby3 = new Hobby();
//
//        hobby1.setName("Playing Football");
//        hobby2.setName("Watching Football");
//        hobby3.setName("Playing Football Game");
//
//        List<Hobby> hobbies = new ArrayList<>();
//        hobbies.add(hobby1);
//        hobbies.add(hobby2);
//        hobbies.add(hobby3);
//
//        Student student = new Student();
//        student.setFirstName("Ahmad");
//        student.setLastName("Mahmoodi");
//        student.setHobbies(hobbies);
//
//        studentRepository.save(student);

        CourseAttendance courseAttendance = new CourseAttendance();

        courseAttendance.setStudent(studentRepository.getOne(Long.valueOf(1)));
        courseAttendance.setCourse(courseRepository.getOne(Long.valueOf(1)));

        courseAttendance.setRegistrationDate(Calendar.getInstance().getTime());

        courseAttendanceRepository.save(courseAttendance);


    }
}
