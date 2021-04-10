package seu.edu.bd.university.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import seu.edu.bd.university.domain.Student;

@Repository
public interface StudentSemester extends JpaRepository<Student, Long> {
}
