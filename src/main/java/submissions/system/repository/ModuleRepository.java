package submissions.system.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import submissions.system.model.Module;

import java.util.List;

@Repository
public interface ModuleRepository extends JpaRepository<Module, Long> {
    @Query(value = "SELECT * FROM modules m WHERE m.module_course_id = ?1", nativeQuery = true)
    List<Module> getModulesByCourseId(Long courseId);
}
