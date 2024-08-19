package zzz.microservice.course.services;

import zzz.microservice.course.entities.CourseEntity;

import java.util.List;

public interface ICourseService {

    List<CourseEntity> findAll();

    CourseEntity findById(Long id);

    CourseEntity save(CourseEntity course);

    CourseEntity update(CourseEntity course);

    void deleteById(Long id);
}
