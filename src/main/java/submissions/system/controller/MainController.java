package submissions.system.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import submissions.system.model.*;
import submissions.system.repository.*;
import submissions.system.service.*;

import java.util.List;

@Controller
public class MainController {

    @Autowired
    private AssignmentService assignmentService;

    @Autowired
    private StudentService studentservice;

    @GetMapping("/dashboard/student/{matNum}")
    public String studentDashboard(@PathVariable("matNum") long matNum, Model model) {
        Student student = studentservice.getStudentById(matNum);
        model.addAttribute("assignments", assignmentService.getAssignmentsByModuleId())
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
