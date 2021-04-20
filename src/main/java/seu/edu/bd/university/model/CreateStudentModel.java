package seu.edu.bd.university.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateStudentModel {


    @NotNull(message = "Please add student name")
    private String studentName;

    @NotNull(message = "Please add gender name")
    private String gender;

    private long studentId;

    private Date dateOfBirth;

    private String bloodGroup;
}
