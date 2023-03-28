package submissions.system.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import submissions.system.model.Assignment;
import submissions.system.repository.AssignmentRepository;
import submissions.system.service.AssignmentService;

import java.util.List;

@RestController
public class AssignmentController {

    @Autowired
    private AssignmentService assignmentService;

    @Autowired
    private AssignmentRepository assignmentRepository;

    @PostMapping("/assignment")
    public Assignment publishAssignment(@RequestBody Assignment assignment) {
        return assignmentService.publishAssignment(assignment);
    }

    @GetMapping({ "/assignments" })
    public ModelAndView getAllAssignments() {
        ModelAndView mav = new ModelAndView("all-assignments");
        mav.addObject("assignments", assignmentRepository.findAll());
        return mav;
    }

    @GetMapping("/assignment/{id}")
    public Assignment getAssignment(@PathVariable("id") Long id) {
        return assignmentService.getAssignmentById(id);
    }

    @PutMapping("/update-assignment/{id}")
    public Assignment updateAssignment(@PathVariable("id") Long id, @RequestBody Assignment assignment) {
        return assignmentService.updateAssignmentById(id, assignment);
    }

    @DeleteMapping("/delete-assignment/{id}")
    public String deleteAssignment(@PathVariable("id") Long id) {
        return assignmentService.deleteAssignmentById(id);
    }

    @GetMapping("/homepage/module/{moduleId}")
    public List<Assignment> getAssignmentsByModuleId(@PathVariable("moduleId") Long userId) {
        return assignmentService.getAssignmentsByModuleId(userId);
    }

}
