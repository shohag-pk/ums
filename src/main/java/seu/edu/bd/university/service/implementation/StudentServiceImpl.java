package seu.edu.bd.university.service.implementation;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import seu.edu.bd.university.domain.Student;
import seu.edu.bd.university.model.CreateStudentModel;
import seu.edu.bd.university.model.UpdateStudentModel;
import seu.edu.bd.university.repository.StudentRepository;
import seu.edu.bd.university.service.StudentService;

import java.util.List;
import java.util.Optional;

@Service
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;

    public StudentServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public Student createStudent(CreateStudentModel studentModel) {
        Optional<Student> studentById = getStudentByStudentId(studentModel.getStudentId());
        if (studentById.isPresent()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Student id is already exist");
        }
        Student newStudent = new Student();
        newStudent.setStudentName(studentModel.getStudentName());
        newStudent.setStudentId(studentModel.getStudentId());
        newStudent.setGender(studentModel.getGender());
        newStudent.setBloodGroup(studentModel.getBloodGroup());
        newStudent.setDateOfBirth(studentModel.getDateOfBirth());
        return studentRepository.save(newStudent);
    }

    @Override
    public List<Student> studentList() {
        return studentRepository.findAll();
    }

    @Override
    public Optional<Student> getStudentById(long studentId) {
        return studentRepository.findById(studentId);
    }

    @Override
    public Optional<Student> getStudentByStudentId(long studentId) {
        return studentRepository.getStudentByStudentId(studentId);
    }

    @Override
    public void deleteStudent(long studentId) {
        Student deleteStudent = getStudentByStudentId(studentId)
                .orElseThrow(()-> new ResponseStatusException(HttpStatus.BAD_REQUEST));
        studentRepository.delete(deleteStudent);

    }

    @Override
    public Student updateStudent(UpdateStudentModel updateStudentModel) {
        Student updateStInfo = getStudentByStudentId(updateStudentModel.getStudentId())
                .orElseThrow(()-> new ResponseStatusException(HttpStatus.BAD_REQUEST));
        updateStInfo.setStudentName(updateStudentModel.getStudentName());
        updateStInfo.setGender(updateStudentModel.getGender());
        updateStInfo.setBloodGroup(updateStudentModel.getBloodGroup());
        return studentRepository.save(updateStInfo);
    }
}
