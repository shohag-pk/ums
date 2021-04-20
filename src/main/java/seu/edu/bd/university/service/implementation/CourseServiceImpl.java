package seu.edu.bd.university.service.implementation;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import seu.edu.bd.university.domain.Course;
import seu.edu.bd.university.domain.Department;
import seu.edu.bd.university.domain.Student;
import seu.edu.bd.university.model.CreateCourseModel;
import seu.edu.bd.university.model.UpdateCourseModel;
import seu.edu.bd.university.repository.CourseRepository;
import seu.edu.bd.university.service.CourseService;

import javax.persistence.*;
import java.util.List;
import java.util.Optional;

@Service
public class CourseServiceImpl implements CourseService {

    private final CourseRepository courseRepository;

    public CourseServiceImpl(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    @Override
    public Course createCourseDetails(CreateCourseModel createCourseModel) {

        Optional<Course> course = findByCourseCode(createCourseModel.getCourseCode());

        if(course.isPresent()){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "courseCode is already exist");
        }

        return new Course(createCourseModel.getCourseTotalCredit(),createCourseModel.getCourseCode(),createCourseModel.getCourseName());
    }

    @Override
    public Optional<Course> findByCourseCode(String courseCode) {
        return courseRepository.findByCourseCode(courseCode);
    }

    @Override
    public List<Course> courseList() {
        return courseRepository.findAll();
    }

    @Override
    public void deleteCourse(String courseCode) {
        Course deleteCourse = findByCourseCode(courseCode)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "CourseCode is not found"));
        courseRepository.delete(deleteCourse);
    }

    @Override
    public Course updateCourseDetails(UpdateCourseModel updateCourseModel) {
        Course updateCourse = findByCourseCode(updateCourseModel.getCourseCode())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "CourseCode is not found"));
        updateCourse.setCourseCode(updateCourseModel.getCourseCode());
        updateCourse.setCourseName(updateCourseModel.getCourseName());
        updateCourse.setCourseTotalCredit(updateCourseModel.getCourseTotalCredit());

        return courseRepository.save(updateCourse);
    }
}
