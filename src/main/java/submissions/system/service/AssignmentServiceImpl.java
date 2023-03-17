package submissions.system.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import submissions.system.model.*;
import submissions.system.repository.AssignmentRepository;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class AssignmentServiceImpl implements AssignmentService {
    @Autowired
    AssignmentRepository assignmentRepository;

    @Override
    public List<Assignment> getAllAssignments() {
        List<Assignment> allAssignments = assignmentRepository.findAll();
        return allAssignments;
    }

    @Override
    public Assignment publishAssignment(Assignment assignment) {
        return assignmentRepository.save(assignment);
    }

    @Override
    public Assignment getAssignmentById(long id) {
        Optional<Assignment> assignment = assignmentRepository.findById(id);
        return assignment.get();
    }

    @Override
    public List<Assignment> getAssignmentsByModuleId(Long moduleId) {
        List<Assignment> assignments = assignmentRepository.getAssignmentsByModuleId(moduleId);
        return assignments;
    }

    @Override
    public Assignment updateAssignmentById(long id, Assignment assignment) {
        Optional<Assignment> assignment1 = assignmentRepository.findById(id);

        if (assignment1.isPresent()) {
            Assignment originalAssignment = assignment1.get();

            if (Objects.nonNull(assignment.getTitle()) && !"".equalsIgnoreCase(assignment.getTitle())) {
                originalAssignment.setTitle(assignment.getTitle());
            }

            if (Objects.nonNull(assignment.getDescription()) && !"".equalsIgnoreCase(assignment.getDescription())) {
                originalAssignment.setDescription(assignment.getDescription());
            }

            return assignmentRepository.save(originalAssignment);
        }
        return null;
    }

    @Override
    public String deleteAssignmentById(Long id) {
        if (assignmentRepository.findById(id).isPresent()) {
            assignmentRepository.deleteById(id);
            return "Assignment deleted sucessfully";
        }
        return "No such assignment in database";
    }

}
