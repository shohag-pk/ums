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
public class Teacher implements Serializable {

    @Id
    @GeneratedValue(strategy= GenerationType.SEQUENCE)
    private int id;


    private String teacherName;

    private String teacherBloodGroup;

    @ManyToMany
    @JsonIgnore
    private List<Department> departments;

    @ManyToMany
    @JsonIgnore
    private List<Subject> subjects;
}
