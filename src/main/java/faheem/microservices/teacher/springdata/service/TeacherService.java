package faheem.microservices.teacher.springdata.service;

import faheem.microservices.teacher.springdata.bean.Course;
import faheem.microservices.teacher.springdata.model.Teacher;
import faheem.microservices.teacher.springdata.repository.TeacherRepository;
import faheem.microservices.teacher.springdata.wrapper.TeacherCourseWrapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class TeacherService {

    @Autowired
    private TeacherRepository teacherRepository;

    @Autowired
    private RestTemplate restTemplate;

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

    public TeacherCourseWrapper getTeacherWithCourseById(Integer teacherId, Integer courseId) throws Exception {
        log.info("TeacherService.getTeacherWithCourseById() method is called...");
        log.info("Teacher id and course id are :"+teacherId+","+courseId);
        String courseUrl = "http://localhost:9092/course/get/";
        Optional<Teacher> optionalTeacher = teacherRepository.findById(teacherId);
          if(optionalTeacher.isPresent()){
              log.info("Teacher with id : "+teacherId+ " found!");
              Teacher teacher = optionalTeacher.get();
              log.info("Retrieving course ....");
              Course course = restTemplate.getForObject(courseUrl+courseId, Course.class);
              if(course!=null){
                  log.info("Course retrieval success");
                  log.info("Course : {}",course);
                  log.info("Creating wrapper class...");
                  TeacherCourseWrapper wrapper = new TeacherCourseWrapper();
                  wrapper.setTeacher(teacher);
                  wrapper.setCourse(course);
                  return wrapper;
              }
              else{
                  throw  new Exception("Course retrieval error!");
              }

          }
          else{
              throw new Exception("Teacher not found exception!");
          }
    }
}
