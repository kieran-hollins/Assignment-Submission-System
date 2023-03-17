package submissions.system.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import submissions.system.model.*;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

}
