package submissions.system.controller;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.userdetails.User;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import submissions.system.model.Student;
import submissions.system.repository.CourseRepository;
import submissions.system.repository.StudentRepository;
import submissions.system.service.CourseService;
import submissions.system.service.StudentService;

import java.util.List;

@Controller
public class StudentController {

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private StudentService studentService;

    @Autowired
    private CourseService courseService;

    @Autowired
    private CourseRepository courseRepository;

    @GetMapping("/register")
    public ModelAndView showRegistrationForm() {
        ModelAndView mav = new ModelAndView("register-student");
        mav.addObject("courses", courseService.getAllCourses());
        return mav;
    }

    @PostMapping("student/register")
    public String registerStudent(@ModelAttribute("student") Student student) {
        studentService.addStudent(student);

        String view = "redirect:/assignments" + student.getId();

        return view;
    }
    

    // public ModelAndView getAllAssignments() {
    //     ModelAndView mav = new ModelAndView("all-assignments");
    //     mav.addObject("assignments", assignmentRepository.findAll());
    //     return mav;
    // }
    
}
