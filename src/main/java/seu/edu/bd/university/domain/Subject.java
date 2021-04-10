package seu.edu.bd.university.domain;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Subject {

    @Id
    @GeneratedValue(strategy= GenerationType.SEQUENCE)
    private int id;

    private String subjectCode;

    private String subjectName;

    private  String subjectCredit;

    @ManyToMany(fetch = FetchType.LAZY, mappedBy = "subjects", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Student> students;

    @ManyToMany(fetch = FetchType.LAZY, mappedBy = "subjects", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Teacher> teachers;
}
