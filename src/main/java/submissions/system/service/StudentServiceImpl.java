package submissions.system.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import submissions.system.model.*;
import submissions.system.repository.StudentRepository;

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

            if (Objects.nonNull(student.getStudentCourseId())) {
                originalStudent.setStudentCourseId(student.getStudentCourseId());
            }

            if (Objects.nonNull(student.getStudentPassword()) && !"".equalsIgnoreCase(student.getStudentPassword())) {
                originalStudent.setStudentPassword(student.getStudentPassword());
            }

            return studentRepository.save(originalStudent);
        }

        return null;
    }

    @Override
    public Student addStudent(Student student) {
        return studentRepository.save(student);
    }
}
