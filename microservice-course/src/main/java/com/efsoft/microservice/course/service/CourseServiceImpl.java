package com.efsoft.microservice.course.service;

import com.efsoft.microservice.course.client.StudentClient;
import com.efsoft.microservice.course.dto.StudentDTO;
import com.efsoft.microservice.course.entitites.Course;
import com.efsoft.microservice.course.http.response.StudentByCourseResponse;
import com.efsoft.microservice.course.persistence.ICourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseServiceImpl implements ICourseService{

    @Autowired
    private ICourseRepository courseRepository;

    @Autowired
    private StudentClient studentClient;

    public List<Course> findAll() {
        return (List<Course>) courseRepository.findAll();
    }

    @Override
    public Course findById(Long id) {
        return courseRepository.findById(id).orElseThrow();
    }

    @Override
    public void save(Course course) {
        courseRepository.save(course);
    }

    @Override
    public StudentByCourseResponse findStudentsByIdCourse(Long idCourse) {

        //Consultar el curso, si no lo encuentra lo creo vacio
        Course course = courseRepository.findById(idCourse).orElse(new Course());

        //Obtener los estudiantes del curso
        List<StudentDTO> studentDTOList = studentClient.findAllStudentByCourse(idCourse);

        return StudentByCourseResponse.builder()
                .courseName(course.getName())
                .teacher(course.getTeacher())
                .studentDTOList(studentDTOList)
                .build();
    }
}
