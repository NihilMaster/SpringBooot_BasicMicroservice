package zzz.microservice.course.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import zzz.microservice.course.dto.StudentDTO;

import java.util.List;

@FeignClient(name = "microservice-student", url = "localhost:8090/api")
public interface IStudentClient {

    @GetMapping("/students/course/{courseId}")
    List<StudentDTO> findAllByCourseId(@PathVariable Long courseId);
}
