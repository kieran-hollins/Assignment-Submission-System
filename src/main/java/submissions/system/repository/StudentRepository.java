package submissions.system.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.security.core.userdetails.*;
import submissions.system.model.*;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
    @Query(value = "SELECT FROM students s WHERE s.email = ?1", nativeQuery = true)
    Student findByEmail(String email);


}
