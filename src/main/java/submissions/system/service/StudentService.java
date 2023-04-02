package submissions.system.service;

import java.util.List;

//import org.springframework.security.core.userdetails.*;
import org.springframework.stereotype.Service;

import submissions.system.model.*;


public interface StudentService {
    List<Student> getAllStudents();

    Student addStudent(Student student);

    Student getStudentById(long matNum);

    Student updateStudentById(long matNum, Student student);

    String deleteStudentById(long matNum);

    //UserDetails loadUserByEmail(String email);
}

