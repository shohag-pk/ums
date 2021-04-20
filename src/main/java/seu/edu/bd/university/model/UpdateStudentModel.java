package seu.edu.bd.university.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateStudentModel {

    private long studentId;
    private String studentName;
    private String gender;
    private String bloodGroup;
}
