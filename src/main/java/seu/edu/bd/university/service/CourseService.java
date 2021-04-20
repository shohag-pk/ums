package seu.edu.bd.university.service;

import seu.edu.bd.university.domain.Course;
import seu.edu.bd.university.model.CreateCourseModel;
import seu.edu.bd.university.model.UpdateCourseModel;

import java.util.List;
import java.util.Optional;

public interface CourseService {
    
    Course createCourseDetails(CreateCourseModel createCourseModel);
    Optional<Course> findByCourseCode(String courseCode);
    List<Course> courseList();
    void deleteCourse(String courseCode);
    Course updateCourseDetails(UpdateCourseModel updateCourseModel);
}
