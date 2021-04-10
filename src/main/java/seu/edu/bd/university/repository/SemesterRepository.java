package seu.edu.bd.university.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import seu.edu.bd.university.domain.Semester;

@Repository
public interface SemesterRepository extends JpaRepository<Semester, Integer> {
}
