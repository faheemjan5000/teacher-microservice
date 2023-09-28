package faheem.microservices.teacher.springdata.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Course {

    private Integer courseId;
    private String courseName;
    private String courseDescription;
}
