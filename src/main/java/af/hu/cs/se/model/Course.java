package af.hu.cs.se.model;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
public class Course {


    private Long id;

    private String courseName;

    private Set<Subject> subjects;

    private Set<Student> students;

    private Set<Lecturer> lecturers;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    @OneToMany(mappedBy = "course")
    public Set<Subject> getSubjects() {
        return subjects;
    }

    public void setSubjects(Set<Subject> subjects) {
        this.subjects = subjects;
    }

    @ManyToMany
    @JoinTable(name = "courses_students", joinColumns = @JoinColumn(name = "course_id"),
    inverseJoinColumns = @JoinColumn(name = "student_id"))
    public Set<Student> getStudents() {
        return students;
    }

    public void setStudents(Set<Student> students) {
        this.students = students;
    }

    @ManyToMany(mappedBy = "courses")
    public Set<Lecturer> getLecturers() {
        return lecturers;
    }

    public void setLecturers(Set<Lecturer> lecturers) {
        this.lecturers = lecturers;
    }
}
