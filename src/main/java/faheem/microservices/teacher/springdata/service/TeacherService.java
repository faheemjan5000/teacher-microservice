package faheem.microservices.teacher.springdata.service;

import faheem.microservices.teacher.springdata.model.Teacher;
import faheem.microservices.teacher.springdata.repository.TeacherRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class TeacherService {

    @Autowired
    private TeacherRepository teacherRepository;

    public Teacher saveTeacher(Teacher teacher){
        log.info("TeacherService.saveTeacher() method is called...");
        return teacherRepository.save(teacher);
    }

    public Teacher getTeacherById(Integer teacherId){
        log.info("TeacherService.getTeacherById() method is called...");
        Optional<Teacher> optionalTeacher = teacherRepository.findById(teacherId);
        if(optionalTeacher.isPresent()){
            log.info("Teacher with id :" +teacherId + " found");
            return optionalTeacher.get();
        }
        else{
            log.error("Teacher with id : "+teacherId+" not found!");
            return null;
        }
    }

    public List<Teacher> getAllTeachers(){
        log.info("TeacherService.getTeacherById() method is called...");
        return teacherRepository.findAll();
    }
}
