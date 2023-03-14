package submissions.system.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import submissions.system.model.*;

import java.util.List;

@Repository
public interface AssignmentRepository extends JpaRepository<Assignment, Long> {

    @Query(value = "SELECT * FROM assignments a WHERE a.assignment_module_id = ?1", nativeQuery = true)
    List<Assignment> getAssignmentsByModuleId(Long moduleId);

}
