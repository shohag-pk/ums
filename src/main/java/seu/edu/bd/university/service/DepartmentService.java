package seu.edu.bd.university.service;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import seu.edu.bd.university.domain.Department;
import seu.edu.bd.university.model.CreateDepartmentModel;
import seu.edu.bd.university.model.UpdateDepartmentModel;
import seu.edu.bd.university.repository.DepartmentRepository;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class DepartmentService {

    public final DepartmentRepository departmentRepository;

    public DepartmentService( DepartmentRepository departmentRepository) {
        this.departmentRepository = departmentRepository;

    }

    public Department createDepartment(CreateDepartmentModel department){
        Department newDepartment = new Department();
        newDepartment.setDepartmentName(department.getDepartmentName());
        newDepartment.setAddDate(LocalDateTime.now());
        return departmentRepository.save(newDepartment);

    }

    public List<Department> departmentList(){
        return departmentRepository.findAll();
    }

    public Department getDepartmentById(int id){
        return departmentRepository.findById(id)
                .orElseThrow(()-> new ResponseStatusException(HttpStatus.BAD_REQUEST, "Department id is not found."));
    }

    public void deleteDepartment(int id){
        Department department1 = getDepartmentById(id);
        departmentRepository.delete(department1);
    }

    public Department updateDepartment(UpdateDepartmentModel department){
        Department updateDepartment = getDepartmentById(department.getDepartmentId());
        updateDepartment.setDepartmentName(department.getDepartmentName());

        return departmentRepository.save(updateDepartment);
    }

}

