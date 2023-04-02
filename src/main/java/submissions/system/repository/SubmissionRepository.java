package submissions.system.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import submissions.system.model.*;

public interface SubmissionRepository extends JpaRepository <Submission, Long> {

}
