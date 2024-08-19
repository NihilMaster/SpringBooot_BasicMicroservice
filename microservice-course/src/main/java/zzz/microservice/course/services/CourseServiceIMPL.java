package zzz.microservice.course.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import zzz.microservice.course.entities.CourseEntity;
import zzz.microservice.course.repositories.ICourseRepository;

import java.util.List;

@Service
public class CourseServiceIMPL implements ICourseService{

    @Autowired
    private ICourseRepository courseRepository;

    @Override
    public List<CourseEntity> findAll() {
        return (List<CourseEntity>) courseRepository.findAll();
    }

    @Override
    public CourseEntity findById(Long id) {
        return courseRepository.findById(id).orElseThrow();
    }

    @Override
    public CourseEntity save(CourseEntity course) {
        return courseRepository.save(course);
    }

    @Override
    public CourseEntity update(CourseEntity course) {

        return courseRepository
                .findById(course.getId()).isPresent() ?
                courseRepository.save(course) :
                null;
    }

    @Override
    public void deleteById(Long id) {
        courseRepository.deleteById(id);
    }
}
