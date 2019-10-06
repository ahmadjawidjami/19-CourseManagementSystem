package af.hu.cs.se.model;


import javax.persistence.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
public class Student {


    private Long id;

    private String firstName;
    private String lastName;

    private String city;
    private String street;
    private Integer doorNumber;
    private String birthDate;
    private List<Hobby> hobbies;

    //private Set<Course> courses;

    private Set<CourseAttendance> courseAttendances;

    private Set<Lecturer> lecturers;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
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

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public Integer getDoorNumber() {
        return doorNumber;
    }

    public void setDoorNumber(Integer doorNumber) {
        this.doorNumber = doorNumber;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    @ElementCollection
//    @CollectionTable(
//            name = "student_hobbies",
//            joinColumns = @JoinColumn(name = "student_id")
//    )
    public List<Hobby> getHobbies() {
        return hobbies;
    }

    public void setHobbies(List<Hobby> hobbies) {
        this.hobbies = hobbies;
    }

    public Student() {
        courseAttendances = new HashSet<>();
    }

//    @ManyToMany(mappedBy = "students")
//    public Set<Course> getCourses() {
//        return courses;
//    }
//
//    public void setCourses(Set<Course> courses) {
//        this.courses = courses;
//    }


    @OneToMany(mappedBy = "student", cascade = CascadeType.ALL)
    public Set<CourseAttendance> getCourseAttendances() {
        return courseAttendances;
    }

    public void setCourseAttendances(Set<CourseAttendance> courseAttendances) {
        this.courseAttendances = courseAttendances;
    }

    @ManyToMany(mappedBy = "students")
    public Set<Lecturer> getLecturers() {
        return lecturers;
    }

    public void setLecturers(Set<Lecturer> lecturers) {
        this.lecturers = lecturers;
    }
}
