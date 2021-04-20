package seu.edu.bd.university.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import seu.edu.bd.university.domain.Course;
import seu.edu.bd.university.model.CreateCourseModel;
import seu.edu.bd.university.model.UpdateCourseModel;
import seu.edu.bd.university.service.CourseService;
import seu.edu.bd.university.service.implementation.CourseServiceImpl;

import javax.validation.Valid;
import java.util.List;

public class CourseController {
    private final CourseService courseService;

    public CourseController(CourseServiceImpl courseService) {
        this.courseService = courseService;
    }

    @PostMapping(value = "/createCourse")
    public ResponseEntity<Course> createCourse(@RequestBody @Valid CreateCourseModel createCourseModel){
        return ResponseEntity.ok(courseService.createCourseDetails(createCourseModel));
    }

    @GetMapping(value = "/getCourseList")
    public List<Course> getCourseList(){
        return courseService.courseList();
    }

    @GetMapping(value = "/deleteCourse/{courseCode}")
    public void deleteCourse(@PathVariable(name = "courseCode") String courseCode){
        courseService.deleteCourse(courseCode);
    }

    @PutMapping(value = "/updateCourse")
    public ResponseEntity<Course> updateCourse(@RequestBody UpdateCourseModel updateCourseModel){
        return ResponseEntity.ok(courseService.updateCourseDetails(updateCourseModel));
    }


}
