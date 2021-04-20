package seu.edu.bd.university.service;

import seu.edu.bd.university.domain.Student;
import seu.edu.bd.university.model.CreateStudentModel;
import seu.edu.bd.university.model.UpdateStudentModel;

import java.util.List;
import java.util.Optional;

public interface StudentService {

    Student createStudent(CreateStudentModel studentModel);

    List<Student> studentList();

    Optional<Student> getStudentById(long studentId);

    Optional<Student> getStudentByStudentId(long studentId);

    void deleteStudent(long studentId);

    Student updateStudent(UpdateStudentModel updateStudentModel);
}
