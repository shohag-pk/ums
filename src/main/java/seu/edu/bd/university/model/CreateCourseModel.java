package seu.edu.bd.university.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import seu.edu.bd.university.domain.Department;

import javax.validation.constraints.NotNull;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateCourseModel {

    @NotNull(message = "Please add courseCode ")
    private String courseCode;

    @NotNull(message = "Please add courseName ")
    private String courseName;

    @NotNull(message = "Please add courseTotalCredit ")
    private int courseTotalCredit;

    private Department department;

}
