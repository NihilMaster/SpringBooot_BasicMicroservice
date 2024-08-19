package zzz.microservice.student.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import zzz.microservice.student.entities.StudentEntity;
import zzz.microservice.student.services.IStudentService;

import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentController {

    @Autowired
    private IStudentService studentService;

    @GetMapping("/students")
    public ResponseEntity<List<StudentEntity>> findAll() {
        return new ResponseEntity<>(studentService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/student/{id}")
    public ResponseEntity<StudentEntity> findById(@PathVariable Long id) {
        return new ResponseEntity<>(studentService.findById(id), HttpStatus.OK);
    }

    @GetMapping("/students/course/{courseId}")
    public ResponseEntity<List<StudentEntity>> findAllByCourseId(@PathVariable Long courseId) {
        return new ResponseEntity<>(studentService.findAllByCourseId(courseId), HttpStatus.OK);
    }

    @PostMapping("/student")
    @ResponseStatus(HttpStatus.CREATED)
    public StudentEntity save(@RequestBody StudentEntity student) {
        return studentService.save(student);
    }

    @DeleteMapping("/student/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteById(@PathVariable Long id) {
        studentService.deleteById(id);
    }
}
