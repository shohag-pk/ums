package seu.edu.bd.university.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity

public class Department implements Serializable {

    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE)
    private int id;

    @Column(nullable = false, unique = true)
    private  String departmentName;

    @Column(nullable = false)
    private LocalDateTime addDate;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "department", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnore
    private List<Course> courses;

    @ManyToMany(fetch = FetchType.LAZY, mappedBy = "departments", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Teacher> teachers;
}
