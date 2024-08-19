package zzz.microservice.course.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import zzz.microservice.course.entities.CourseEntity;

@Repository
public interface ICourseRepository extends CrudRepository<CourseEntity, Long> {
}
