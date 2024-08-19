package zzz.microservice.course.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import zzz.microservice.course.client.IStudentClient;
import zzz.microservice.course.entities.CourseEntity;
import zzz.microservice.course.http.response.StudentByCourseResponse;
import zzz.microservice.course.repositories.ICourseRepository;

import java.util.List;

@Service
public class CourseServiceIMPL implements ICourseService{

    @Autowired
    private ICourseRepository courseRepository;

    @Autowired
    private IStudentClient studentClient;

    @Override
    public List<CourseEntity> findAll() {
        return (List<CourseEntity>) courseRepository.findAll();
    }

    @Override
    public CourseEntity findById(Long id) {
        return courseRepository.findById(id).orElseThrow();
    }

    @Override
    public StudentByCourseResponse findAllByCourseId(Long courseId) {
        return courseRepository
                .findById(courseId).isPresent() ?
                StudentByCourseResponse.builder()
                        .courseName(courseRepository.findById(courseId).get().getName())
                        .teacher(courseRepository.findById(courseId).get().getTeacher())
                        .studentsDTOList(studentClient.findAllByCourseId(courseId))
                        .build() : null;
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
