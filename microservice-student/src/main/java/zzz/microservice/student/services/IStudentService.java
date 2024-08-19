package zzz.microservice.student.services;

import zzz.microservice.student.entities.StudentEntity;

import java.util.List;

public interface IStudentService {

    List<StudentEntity> findAll();

    StudentEntity findById(Long id);

    List<StudentEntity> findAllByCourseId(Long courseId);

    StudentEntity save(StudentEntity student);

    void deleteById(Long id);
}
