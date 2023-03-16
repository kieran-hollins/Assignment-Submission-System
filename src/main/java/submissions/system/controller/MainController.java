package submissions.system.controller;

import org.springframework.stereotype.Controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import submissions.system.model.Assignment;
import submissions.system.service.AssignmentService;

import java.util.List;

@Controller
public class MainController {
    @RequestMapping("/")
    public String dashboard()   {
        return "dashboard";
    }
}
