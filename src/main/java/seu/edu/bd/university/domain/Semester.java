package seu.edu.bd.university.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity

public class Semester {

    @Id
    @GeneratedValue(strategy= GenerationType.SEQUENCE)
    private int id;

    private String semesterName;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "semesters", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Student> students;
}
