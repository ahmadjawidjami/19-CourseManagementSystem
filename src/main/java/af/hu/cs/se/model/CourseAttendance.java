package af.hu.cs.se.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
public class CourseAttendance implements Serializable {

    private Long id;
//    private CourseAttendanceKey id;
    private Student student;
    private Course course;
    private Date registrationDate;


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }



    //    @EmbeddedId
//    public CourseAttendanceKey getId() {
//        return id;
//    }
//
//    public void setId(CourseAttendanceKey id) {
//        this.id = id;
//    }

   // @Id
    //@MapsId("student_id")
    @ManyToOne
    @JoinColumn(name = "student_id")
    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    //@Id
    //@MapsId("course_id")
    @ManyToOne
    @JoinColumn(name = "course_id")
    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public Date getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(Date registrationDate) {
        this.registrationDate = registrationDate;
    }
}
