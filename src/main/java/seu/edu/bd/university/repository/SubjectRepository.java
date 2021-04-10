package seu.edu.bd.university.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import seu.edu.bd.university.domain.Subject;

@Repository
public interface SubjectRepository extends JpaRepository<Subject, Integer> {
}
