package af.hu.cs.se.model;

import javax.persistence.*;

@Entity
public class Subject {

    @Column(name = "subject_id")
    private Long id;

    private String subjectName;

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
}
