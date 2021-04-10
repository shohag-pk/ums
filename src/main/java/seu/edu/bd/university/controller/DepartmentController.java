package seu.edu.bd.university.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import seu.edu.bd.university.domain.Department;
import seu.edu.bd.university.model.CreateDepartmentModel;
import seu.edu.bd.university.model.UpdateDepartmentModel;
import seu.edu.bd.university.service.DepartmentService;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value = "/department")
public class DepartmentController {

    private final DepartmentService departmentService;

    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @PostMapping(value = "/create")
    public ResponseEntity<Department> createDepartment(@RequestBody @Valid CreateDepartmentModel department){
        return ResponseEntity.ok(departmentService.createDepartment(department));
    }

    @GetMapping(value = "/departmentList")
    public ResponseEntity<List<Department>> departmentList(){
        return ResponseEntity.ok(departmentService.departmentList());
    }

    @DeleteMapping(value = "/delete/{id}}")
    public void deleteDepartment(@PathVariable(name = "id") int id){
        departmentService.deleteDepartment(id);
    }

    @PutMapping(value = "/updateDepartment")
    public ResponseEntity<Department> updateDepartment(@RequestBody UpdateDepartmentModel updateDepartmentModel){
        return ResponseEntity.ok(departmentService.updateDepartment(updateDepartmentModel));
    }
}
