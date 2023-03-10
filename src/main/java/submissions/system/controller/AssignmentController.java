package submissions.system.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import submissions.system.model.Assignment;
import submissions.system.service.AssignmentService;

import java.util.List;

@RestController
public class AssignmentController {

    @Autowired
    private AssignmentService assignmentService;

    @PostMapping("/assignment")
    public Assignment publishAssignment(@RequestBody Assignment assignment) {
        return assignmentService.publishAssignment(assignment);
    }

    @GetMapping("/assignment")
    public List<Assignment> getAllAssignments() {
        return assignmentService.getAllAssignments();
    }

    @GetMapping("/assignment/{id}")
    public Assignment getAssignment(@PathVariable("id") Long id) {
        return assignmentService.getAssignmentById(id);
    }

    @PutMapping("/assignment/{id}")
    public Assignment updateAssignment(@PathVariable("id") Long id, @RequestBody Assignment assignment) {
        return assignmentService.updateAssignmentById(id, assignment);
    }

    @DeleteMapping("/assignment/{id}")
    public String deleteAssignment(@PathVariable("id") Long id) {
        return assignmentService.deleteAssignmentById(id);
    } 

}
