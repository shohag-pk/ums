package seu.edu.bd.university.domain;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Course implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int id;

    @Column(unique = true)
    private String courseCode;

    @Column(unique = true)
    private String courseName;

    private int courseTotalCredit;

    @ManyToOne
    private Department department;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "course", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnore
    private List<Student> students;

    public Course(int courseTotalCredit, String courseCode, String courseName) {
        this.courseCode = courseCode;
        this.courseName = courseName;
        this.courseTotalCredit = courseTotalCredit;
    }
}