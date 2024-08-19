package zzz.microservice.student.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import zzz.microservice.student.entities.StudentEntity;

import java.util.List;

@Repository
public interface IStudentRepository extends CrudRepository<StudentEntity, Long> {

    /*
    * Otra forma de hacerlo saliéndose de los parámetros de JPA:
    *   @Query("SELECT s FROM StudentEntity s WHERE s.courseId = :courseId")
    *   List<StudentEntity> findAllStudents(Long courseId);
    * */
    List<StudentEntity> findAllByCourseId(Long courseId);
}
