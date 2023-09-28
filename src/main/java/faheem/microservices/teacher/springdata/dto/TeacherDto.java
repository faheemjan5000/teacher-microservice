package faheem.microservices.teacher.springdata.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TeacherDto {
    private String teacherName;
    private String teacherEmail;
    private Integer courseId;
}
