package com.efsoft.microservice.course.persistence;

import com.efsoft.microservice.course.entitites.Course;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICourseRepository extends CrudRepository<Course, Long> {

}
