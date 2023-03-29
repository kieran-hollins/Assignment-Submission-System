package submissions.system.service;

import java.util.List;

import org.springframework.stereotype.Service;

import submissions.system.model.*;


public interface AssignmentService {
    List<Assignment> getAllAssignments();

    Assignment publishAssignment(Assignment assignment);

    Assignment getAssignmentById(long id);

    Assignment updateAssignmentById(long id, Assignment assignment);

    String deleteAssignmentById(Long id);

    List<Assignment> getAssignmentsByModuleId(Long moduleId);

}
