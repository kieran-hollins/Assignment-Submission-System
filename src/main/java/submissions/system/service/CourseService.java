package submissions.system.service;

import java.util.List;

import org.springframework.stereotype.Service;

import submissions.system.model.*;


public interface CourseService {
    List<Course> getAllCourses();

    Course createCourse(Course course);

    Course getCourseById(long id);

    Course updateCourseById(long id, Course course);

    String deleteCourseById(long id);

}
