package submissions.system.model;

import java.io.Serializable;
import org.springframework.web.multipart.MultipartFile;

import io.micrometer.common.lang.Nullable;

public class Upload implements Serializable {

    private long id;

    private String title;

    private String description;

    @Nullable
    private MultipartFile file;

    private long moduleId;

    private long matNum;

    public Upload() {
        super();
    }

    public Upload(long id, String title, String description, MultipartFile file, long moduleId, long matNum) {
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

    public MultipartFile getFile() {
        return file;
    }

    public void setFile(MultipartFile file) {
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

    public void setMatNum(Long matNum) {
        this.matNum = matNum;
    }

}
