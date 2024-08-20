package zzz.microservice.course.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import zzz.microservice.course.entities.CourseEntity;
import zzz.microservice.course.services.ICourseService;

import java.util.List;

@RestController
@RequestMapping("/api/c")
public class CourseController {

    @Autowired
    private ICourseService courseService;

    @GetMapping("/courses")
    public ResponseEntity<List<CourseEntity>> findAll() {
        return new ResponseEntity<List<CourseEntity>>(courseService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/course/{id}")
    public ResponseEntity<CourseEntity> findById(@PathVariable Long id) {
        return new ResponseEntity<CourseEntity>(courseService.findById(id), HttpStatus.OK);
    }

    @GetMapping("/course/{courseId}/students")
    public ResponseEntity<?> findAllByCourseId(@PathVariable Long courseId) {
        return ResponseEntity.ok(courseService.findAllByCourseId(courseId));
    }

    @PostMapping("/course")
    @ResponseStatus(HttpStatus.CREATED)
    public CourseEntity save(@RequestBody CourseEntity course) {
        return courseService.save(course);
    }

    @PutMapping("/course/{id}")
    @ResponseStatus(HttpStatus.OK)
    public CourseEntity update(@RequestBody CourseEntity course, @PathVariable Long id) {
        course.setId(id);
        return courseService.update(course);
    }

    @DeleteMapping("/course/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteById(@PathVariable Long id) {
        courseService.deleteById(id);
    }
}
