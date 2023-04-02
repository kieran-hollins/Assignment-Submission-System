package submissions.system.controller;

import org.springframework.stereotype.Controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import submissions.system.model.Assignment;
import submissions.system.model.Course;
import submissions.system.model.Student;
import submissions.system.model.Module;
import submissions.system.repository.AssignmentRepository;
import submissions.system.repository.StudentRepository;
import submissions.system.service.AssignmentService;
import submissions.system.service.CourseService;
import submissions.system.service.ModuleService;
import submissions.system.service.StudentService;

import java.util.ArrayList;
import java.util.List;

@Controller
public class AssignmentController {

    @Autowired
    private AssignmentService assignmentService;

    @Autowired
    private AssignmentRepository assignmentRepository;

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private StudentService studentService;

    @Autowired
    private CourseService courseService;

    @Autowired
    private ModuleService moduleService; 

    @PostMapping(value = "/assignment"/* , consumes = {"application/json"}*/)
    public Assignment publishAssignment(@RequestBody Assignment assignment) {
        return assignmentService.publishAssignment(assignment);
    }

    @GetMapping({ "/assignments" })
    public ModelAndView getAllAssignments() {
        ModelAndView mav = new ModelAndView("all-assignments");
        mav.addObject("assignments", assignmentRepository.findAll());
        return mav;
    }

    @GetMapping({ "/assignments/{id}" })
    public ModelAndView getAssignment(@PathVariable Long id) {
        Student student = studentService.getStudentById(id);
        Course course = courseService.getCourseById(student.getStudentCourseId());
        List<Module> modules = moduleService.getModulesByCourseId(course.getId());
        List<Assignment> assignmentsTemp = new ArrayList<>();
        List<Assignment> assignments = new ArrayList<>();

        for (Module module : modules) {
            assignmentsTemp = assignmentService.getAssignmentsByModuleId(module.getId());
            for (Assignment assignment : assignmentsTemp) {
                assignments.add(assignment);
            }
        }

        ModelAndView mav = new ModelAndView("assignment");

        mav.addObject("assignment", assignments);
        return mav;
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
