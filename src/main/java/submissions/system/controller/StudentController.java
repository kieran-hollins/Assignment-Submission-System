package submissions.system.controller;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.userdetails.User;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import submissions.system.model.Student;
import submissions.system.repository.StudentRepository;
import submissions.system.service.StudentService;

import java.util.List;

@Controller
public class StudentController {

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private StudentService studentService;

    @GetMapping("/register")
    public String showRegistrationForm() {
        return "register";
    }

    @PostMapping("/register")
    public String registerStudent(@ModelAttribute("student") Student student, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "register";
        }
        studentRepository.save(student);
        return "redirect:/login";
    }
    

    // public ModelAndView getAllAssignments() {
    //     ModelAndView mav = new ModelAndView("all-assignments");
    //     mav.addObject("assignments", assignmentRepository.findAll());
    //     return mav;
    // }
    
}
