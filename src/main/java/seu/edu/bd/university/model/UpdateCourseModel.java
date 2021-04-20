package seu.edu.bd.university.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateCourseModel {

    private String courseCode;
    private String courseName;
    private int courseTotalCredit;
}
