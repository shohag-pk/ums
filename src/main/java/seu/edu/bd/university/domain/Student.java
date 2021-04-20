package seu.edu.bd.university.domain;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Student {

    @Id
    @GeneratedValue(strategy= GenerationType.SEQUENCE)
    private long id;

    @Column(unique = true)
    private long studentId;

    private String studentName;

    private String gender;

    private Date dateOfBirth;

    private String bloodGroup;

    @ManyToOne
    private Semester semesters;

    @ManyToOne
    private Course course;

    @ManyToMany
    @JsonIgnore
    private List<Subject> subjects;
}
