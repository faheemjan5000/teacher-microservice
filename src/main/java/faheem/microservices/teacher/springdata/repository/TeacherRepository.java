package faheem.microservices.teacher.springdata.repository;

import faheem.microservices.teacher.springdata.model.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TeacherRepository extends JpaRepository<Teacher,Integer> {

}
