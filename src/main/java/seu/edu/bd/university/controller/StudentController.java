package seu.edu.bd.university.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import seu.edu.bd.university.domain.Student;
import seu.edu.bd.university.model.CreateStudentModel;
import seu.edu.bd.university.model.UpdateStudentModel;
import seu.edu.bd.university.service.StudentService;
import seu.edu.bd.university.service.implementation.StudentServiceImpl;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value = "/student")
public class StudentController {

    private final StudentService studentService;

    public StudentController(StudentServiceImpl studentService) {
        this.studentService = studentService;
    }

    @PostMapping(value = "/createStudent")
    public ResponseEntity<Student> createStudent(@RequestBody @Valid CreateStudentModel studentModel){
        return ResponseEntity.ok(studentService.createStudent(studentModel));

    }

    @GetMapping(value = "/allStudentList")
    public ResponseEntity<List<Student>> getAllStudentList(){
        return ResponseEntity.ok(studentService.studentList());
    }

    @GetMapping(value = "/deleteStudent/{id}")
    public void deleteStudent(@PathVariable (name = "id") long id){
         studentService.deleteStudent(id);
    }

    @PutMapping(value = "/updateStudent")
    public ResponseEntity<Student> updateStudent(@RequestBody UpdateStudentModel updateStudentModel){
        return ResponseEntity.ok(studentService.updateStudent(updateStudentModel));
    }
}
