package submissions.system.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import submissions.system.model.*;
import submissions.system.repository.CourseRepository;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class CourseServiceImpl implements CourseService {
    @Autowired
    CourseRepository courseRepository;

    public List<Course> getAllCourses() {
        List<Course> allCourses = courseRepository.findAll();
        return allCourses;
    }

    public Course getCourseById(long id) {
        Optional<Course> course = courseRepository.findById(id);
        return course.get();
    }

    public Course createCourse(Course course) {
        return courseRepository.save(course);
    }

    public Course updateCourseById(long id, Course course) {
        Optional<Course> course1 = courseRepository.findById(id);

        if (course1.isPresent()) {
            Course originalCourse = course1.get();

            if (Objects.nonNull(course.getCourseName()) && !"".equalsIgnoreCase(course.getCourseName())) {
                originalCourse.setCourseName(course.getCourseName());
            }

            if (Objects.nonNull(course.getCourseCredits())) {
                originalCourse.setCourseCredits(course.getCourseCredits());
            }

            return courseRepository.save(originalCourse);
        }
        return null;
    }

    @Override
    public String deleteCourseById(long id) {
        if (courseRepository.findById(id).isPresent()) {
            courseRepository.deleteById(id);
            return "Course deleted sucessfully";
        }
        return "No such course in database";
    }

}
