package submissions.system.model;

import java.io.Serializable;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "students")
public class Student implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "matnum")
    private long matNum;

    @Column(name = "first_name")
    private String fName;

    @Column(name = "last_name")
    private String lName;

    @Column(name = "student_course_id")
    private long courseId;

    @Column(name = "password_hash")
    private String passwordHash;

    public Student() {
        super();
    }

    public Student(long matNum, String fName, String lName) {
        super();
        this.matNum = matNum;
        this.fName = fName;
        this.lName = lName;
    }

    public void setId(long matNum) {
        this.matNum = matNum;
    }

    public String getFirstName() {
        return fName;
    }

    public void setFirstName(String fName) {
        this.fName = fName;
    }

    public String getLastName() {
        return lName;
    }

    public void setLastName(String lName) {
        this.lName = lName;
    }

    public long getStudentCourseId() {
        return courseId;
    }

    public void setStudentCourseId(long courseId) {
        this.courseId = courseId;
    }

    public String getStudentPassword() {
        return passwordHash;
    }

    public void setStudentPassword(String passwordHash) {
        this.passwordHash = passwordHash;
    }

    @Override
    public String toString() {
        return "Student [matriculation number=" + matNum + ", name=" + fName + " " + lName + ", course ID=" + courseId
                + "]";
    }

}
