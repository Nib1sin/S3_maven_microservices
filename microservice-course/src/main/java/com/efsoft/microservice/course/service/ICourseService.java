package com.efsoft.microservice.course.service;

import com.efsoft.microservice.course.entitites.Course;

import java.util.List;

public interface ICourseService {

    List<Course> findAll();

    Course findById(Long id);

    void save(Course course);

}
