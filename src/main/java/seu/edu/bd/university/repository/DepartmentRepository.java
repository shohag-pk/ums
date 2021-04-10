package seu.edu.bd.university.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import seu.edu.bd.university.domain.Department;

import java.util.Optional;


@Repository
public interface DepartmentRepository extends JpaRepository<Department, Integer> {


}
