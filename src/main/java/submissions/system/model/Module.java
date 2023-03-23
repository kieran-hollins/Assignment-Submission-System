package submissions.system.model;

import java.io.Serializable;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "modules")
public class Module implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "module_id")
    private long id;

    @Column(name = "module_name")
    private String name;

    @Column(name = "module_Course_id")
    private long courseId;

    @Column(name = "credits")
    private int credits;

    public Module() {
        super();
    }

    public Module(long id, String name, long courseId, int credits) {
        super();
        this.id = id;
        this.name = name;
        this.courseId = courseId;
        this.credits = credits;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCourseName() {
        return name;
    }

    public void setCourseName(String name) {
        this.name = name;
    }

    public long getCourseId() {
        return courseId;
    }

    public void setCourseId(long courseId) {
        this.courseId = courseId;
    }

    public int getCredits() {
        return credits;
    }

    @Override
    public String toString() {
        return "Module [id=" + id + ", name=" + name + ", course ID=" + courseId + ", credits=" + credits + "]";
    }

}
