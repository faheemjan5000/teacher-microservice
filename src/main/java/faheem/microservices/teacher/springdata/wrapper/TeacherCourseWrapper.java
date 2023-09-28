package faheem.microservices.teacher.springdata.wrapper;

import faheem.microservices.teacher.springdata.bean.Course;
import faheem.microservices.teacher.springdata.model.Teacher;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TeacherCourseWrapper {

    private Teacher teacher;
    private Course course;

}
