package af.hu.cs.se.model;

import javax.persistence.*;

@Entity
public class Course {

    @Column(name = "course_id")
    private Long id;

    private String courseName;

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
}
