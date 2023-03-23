package submissions.system.model;

import java.io.Serializable;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "assignments")
public class Assignment implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "assignment_id")
    private long id;

    @Column(name = "title")
    private String title;

    @Column(name = "description")
    private String description;

    @Column(name = "credits")
    private int credits;

    @Column(name = "assignment_module_id")
    private long moduleId;

    public Assignment() {
        super();
    }

    public Assignment(long id, String title, String description, int credits, long moduleId) {
        super();
        this.id = id;
        this.title = title;
        this.description = description;
        this.credits = credits;
        this.moduleId = moduleId;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getCredits() {
        return credits;
    }

    public void setCredits(int credits) {
        this.credits = credits;
    }

    public long getModuleId() {
        return moduleId;
    }

    public void setModuleId(long moduleId) {
        this.moduleId = moduleId;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Assignment other = (Assignment) obj;
        if (title == null) {
            if (other.title != null)
                return false;
        } else if (!title.equals(other.title))
            return false;
        if (id != other.id)
            return false;
        if (description == null) {
            if (other.description != null)
                return false;
        } else if (!description.equals(other.title))
            return false;
        if (credits != other.credits)
            return false;
        if (moduleId != other.moduleId)
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Assignment [id=" + id + ", title=" + title + ", description=" + description + ", credits=" + credits
                + ", moduleID=" + moduleId + "]";
    }

}
