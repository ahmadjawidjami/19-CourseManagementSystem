package af.hu.cs.se.model;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
public class Lecturer {

    private Long id;

    private String firstName;
    private String lastName;

    private Set<Subject> subject;

    private Set<Student> students;

    private Set<Course> courses;

    @Id
    @GeneratedValue
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

//    @OneToOne
//    @JoinColumn(name = "subject_id")
//    public Subject getSubject() {
//        return subject;
//    }
//
//    public void setSubject(Subject subject) {
//        this.subject = subject;
//    }


    @OneToMany(mappedBy = "lecturer", cascade = CascadeType.ALL)
    public Set<Subject> getSubject() {
        return subject;
    }

    public void setSubject(Set<Subject> subject) {
        this.subject = subject;
    }

    @ManyToMany
    @JoinTable(name = "lecturers_students", joinColumns = @JoinColumn(name = "lecturer_id"),
    inverseJoinColumns = @JoinColumn(name = "student_id"))
    public Set<Student> getStudents() {
        return students;
    }

    public void setStudents(Set<Student> students) {
        this.students = students;
    }

    @ManyToMany
    @JoinTable(name = "courses_lectures", joinColumns = @JoinColumn(name = "lecturer_id"),
            inverseJoinColumns = @JoinColumn(name = "course_id"))
    public Set<Course> getCourses() {
        return courses;
    }

    public void setCourses(Set<Course> courses) {
        this.courses = courses;
    }
}
