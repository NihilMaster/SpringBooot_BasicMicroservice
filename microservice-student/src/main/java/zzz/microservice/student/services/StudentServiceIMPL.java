package zzz.microservice.student.services;

import org.springframework.beans.factory.annotation.Autowired;
import zzz.microservice.student.entities.StudentEntity;
import zzz.microservice.student.repositories.IStudentRepository;

import java.util.List;

public class StudentServiceIMPL implements IStudentService{

    @Autowired
    private IStudentRepository studentRepository;

    @Override
    public List<StudentEntity> findAll() {
        return (List<StudentEntity>) studentRepository.findAll();
    }

    @Override
    public StudentEntity findById(Long id) {
        return studentRepository.findById(id).orElseThrow();
    }

    @Override
    public List<StudentEntity> findAllByCourseId(Long courseId) {
        return studentRepository.findAllByCourseId(courseId);
    }

    @Override
    public StudentEntity save(StudentEntity student) {
        return studentRepository.save(student);
    }

    @Override
    public void deleteById(Long id) {
        studentRepository.deleteById(id);
    }
}
