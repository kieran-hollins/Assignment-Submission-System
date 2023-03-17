package submissions.system.controller;

import org.springframework.stereotype.Controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import submissions.system.model.*;
import submissions.system.service.*;

import java.util.List;

@Controller
public class MainController {

    @Autowired
    private AssignmentService assignmentService;

    @RequestMapping("/dashboard/{matNum}")
    public String dashboard(@ModelAttribute("matNum") Student student) {
        List<Assignment> = 
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
