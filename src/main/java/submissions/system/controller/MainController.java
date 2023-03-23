package submissions.system.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import submissions.system.model.*;
import submissions.system.model.Module;
import submissions.system.repository.*;
import submissions.system.service.*;

import java.util.List;

@Controller
public class MainController {

    @Autowired
    private AssignmentService assignmentService;

    @Autowired
    private StudentService studentservice;

    @Autowired
    private ModuleService moduleService;

    @Autowired
    private CourseService courseService;

    @GetMapping("/dashboard/student/{matNum}")
    public String studentDashboard(@PathVariable long matNum, Model model) {
        Student student = studentservice.getStudentById(matNum);
        Course course = courseService.getCourseById(student.getStudentCourseId());
        List<Module> modules = moduleService.getModulesByCourseId(course.getId());
        model.addAttribute("assignments", )
        return "dashboard";
    }

    @RequestMapping("/login")
    public String login() {
        return "login";
    }

    @RequestMapping("/register")
    public String register() {
        return "register";
    }
}
