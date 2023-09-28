package faheem.microservices.teacher.springdata.controller;

import faheem.microservices.teacher.springdata.dto.TeacherDto;
import faheem.microservices.teacher.springdata.mapper.UtilityMapping;
import faheem.microservices.teacher.springdata.model.Teacher;
import faheem.microservices.teacher.springdata.service.TeacherService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
@RequestMapping("/teacher")
public class TeacherController {

    @Autowired
    private TeacherService teacherService;

    @PostMapping("/add")
    public Teacher addTeacher(@RequestBody() Teacher teacher){
        log.info("TeacherController.addTeacher() method is called...");
        //Teacher teacher = UtilityMapping.mapTeacherDtoToTeacher(teacherDto);
        Teacher teacherSaved = teacherService.saveTeacher(teacher);;
        if(teacherSaved!=null){
            log.info("Successfully added a new Teacher!");
        }
        return teacherSaved;
    }

    @GetMapping("/get/{id}")
    public Teacher findTeacherById(@PathVariable("id") Integer teacherId){
        log.info("TeacherController.findTeacherById() method is called...");
        return teacherService.getTeacherById(teacherId);
    }

    @GetMapping("/all")
    public List<Teacher> getAllTeachers(){
        log.info("TeacherController.getAllTeachers() method is called...");
        return teacherService.getAllTeachers();
    }

}
