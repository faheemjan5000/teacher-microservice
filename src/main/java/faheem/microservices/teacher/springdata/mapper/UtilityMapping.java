package faheem.microservices.teacher.springdata.mapper;

import faheem.microservices.teacher.springdata.dto.TeacherDto;
import faheem.microservices.teacher.springdata.model.Teacher;

public class UtilityMapping {

    public static Teacher mapTeacherDtoToTeacher(TeacherDto teacherDto){
      Teacher teacher = new Teacher();
      teacher.setTeacherEmail(teacherDto.getTeacherEmail());
      teacher.setTeacherName(teacherDto.getTeacherName());
      teacher.setCourseId(teacherDto.getCourseId());
      return teacher;
    }
}
