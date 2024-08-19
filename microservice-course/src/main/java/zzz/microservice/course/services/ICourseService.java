package zzz.microservice.course.services;

import zzz.microservice.course.entities.CourseEntity;
import zzz.microservice.course.http.response.StudentByCourseResponse;

import java.util.List;

public interface ICourseService {

    List<CourseEntity> findAll();

    CourseEntity findById(Long id);

    StudentByCourseResponse findAllByCourseId(Long courseId);

    CourseEntity save(CourseEntity course);

    CourseEntity update(CourseEntity course);

    void deleteById(Long id);
}
