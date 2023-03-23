package submissions.system.model;

import java.io.Serializable;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "courses")
public class Course implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "course_id")
    private long courseId;

    @Column(name = "course_name")
    private String courseName;

    @Column(name = "credits")
    private int credits;

    public Course() {
        super();
    }

    public Course(long courseId, String courseName, int credits) {
        super();
        this.courseId = courseId;
        this.courseName = courseName;
        this.credits = credits;
    }

    public long getId() {
        return courseId;
    }

    public void setId(long courseId) {
        this.courseId = courseId;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public int getCourseCredits() {
        return credits;
    }

    public void setCourseCredits(int credits) {
        this.credits = credits;
    }

    @Override
    public String toString() {
        return "Course [id=" + courseId + ", name=" + courseName + ", credits=" + credits + "]";
    }

}
