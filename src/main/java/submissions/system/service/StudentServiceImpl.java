package submissions.system.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
//import org.springframework.security.core.userdetails.*;
import org.springframework.stereotype.Service;

import submissions.system.model.*;
import submissions.system.repository.StudentRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    StudentRepository studentRepository;

    @Override
    public List<Student> getAllStudents() {
        List<Student> allStudents = studentRepository.findAll();
        return allStudents;
    }

    @Override
    public Student getStudentById(long matNum) {
        Optional<Student> student = studentRepository.findById(matNum);
        return student.get();
    }

    @Override
    public Student updateStudentById(long matNum, Student student) {
        Optional<Student> student1 = studentRepository.findById(matNum);

        if (student1.isPresent()) {
            Student originalStudent = student1.get();

            if (Objects.nonNull(student.getFirstName()) && !"".equalsIgnoreCase(student.getFirstName())) {
                originalStudent.setFirstName(student.getFirstName());
            }

            if (Objects.nonNull(student.getLastName()) && !"".equalsIgnoreCase(student.getLastName())) {
                originalStudent.setLastName(student.getLastName());
            }

            if (Objects.nonNull(student.getEmail()) && !"".equalsIgnoreCase(student.getEmail())) {
                originalStudent.setEmail(student.getEmail());
            }

            if (Objects.nonNull(student.getStudentCourseId())) {
                originalStudent.setStudentCourseId(student.getStudentCourseId());
            }

            if (Objects.nonNull(student.getPassword()) && !"".equalsIgnoreCase(student.getPassword())) {
                originalStudent.setPassword(student.getPassword());
            }

            return studentRepository.save(originalStudent);
        }

        return null;
    }

    @Override
    public Student addStudent(Student student) {
        return studentRepository.save(student);
    }

    @Override
    public String deleteStudentById(long id) {
        if (studentRepository.findById(id).isPresent()) {
            studentRepository.deleteById(id);
            return "Student deleted sucessfully";
        }
        return "No such student in database";
    }

    // @Override
    // public UserDetails loadUserByEmail(String email) throws UsernameNotFoundException {
    //     Student user = studentRepository.findByEmail(email);
    //     if (user == null) {
    //         throw new UsernameNotFoundException("User not found");
    //     }
    //     return new org.springframework.security.core.userdetails.User(user.getEmail(), user.getPassword(),
    //             new ArrayList<>());
    // }
}
