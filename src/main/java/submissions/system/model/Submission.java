package submissions.system.model;

import java.io.Serializable;
import java.sql.Blob;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "submissions")
public class Submission implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "submission_id")
    private long id;

    @Column(name = "title")
    private String title;

    @Column(name = "description")
    private String description;

    @Column(name = "file")
    private Blob file;

    @Column(name = "submission_module_id")
    private long moduleId;

    @Column(name = "submission_matnum")
    private long matNum;

    public Submission() {
        super();
    }

    public Submission(long id, String title, String description, Blob file, long moduleId, long matNum) {
        super();
        this.id = id;
        this.title = title;
        this.description = description;
        this.file = file;
        this.moduleId = moduleId;
        this.matNum = matNum;
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

    public Blob getFile() {
        return file;
    }

    public void setFile(Blob file) {
        this.file = file;
    }

    public long getModuleId() {
        return moduleId;
    }

    public void setModuleId(long moduleId) {
        this.moduleId = moduleId;
    }

    public long getMatNum() {
        return matNum;
    }

    public void setMatNum(long matNum) {
        this.matNum = matNum;
    }

}
