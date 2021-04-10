package seu.edu.bd.university.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateDepartmentModel {
    @NotNull(message = "Please add department name")
    private String departmentName;
}
