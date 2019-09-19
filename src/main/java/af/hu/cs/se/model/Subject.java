package af.hu.cs.se.model;

import javax.persistence.*;

@Entity
public class Subject {

    @Column(name = "subject_id")
    private Long id;

    private String subjectName;

    private Course course;

    private Lecturer lecturer;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSubjectName() {
        return subjectName;
    }

    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }

    @ManyToOne
    @JoinColumn(name = "course_id")
    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    @OneToOne(mappedBy = "subject")
    public Lecturer getLecturer() {
        return lecturer;
    }

    public void setLecturer(Lecturer lecturer) {
        this.lecturer = lecturer;
    }
}
