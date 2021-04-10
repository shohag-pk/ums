package seu.edu.bd.university.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import seu.edu.bd.university.domain.Teacher;

@Repository
public interface TeacherRepository extends JpaRepository<Teacher,Integer> {
}
