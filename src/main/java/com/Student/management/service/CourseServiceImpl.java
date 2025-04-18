package com.Student.management.service;

import com.Student.management.entity.CourseEntity;
import com.Student.management.model.CourseModel;
import com.Student.management.repository.CourseRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CourseServiceImpl implements CourseService{


    @Autowired
    private CourseRepository courseRepository;

    @Override
    public CourseModel createCourse(CourseModel courseModel) {

        ObjectMapper mapper = new ObjectMapper();


        CourseEntity courseEntity = new CourseEntity();
        mapper.convertValue(courseModel, CourseEntity.class);
        courseModel.mapModelToEntity(courseEntity);
        courseRepository.save(courseEntity);

        return courseModel.mapEntityToModel(courseEntity);

    }

    @Override
    public CourseModel getCourseDetailsByCourseId(long courseId) {

        CourseModel model = new CourseModel();
        CourseEntity courseDetails = courseRepository.getByCourseId(courseId);

        return model.mapEntityToModel(courseDetails);

    }

    @Override
    public List<CourseModel> getCourseDetailsByCourseName(String name) {

        try {
            List<CourseModel> courseModelList = new ArrayList<>();
            List<CourseEntity> courseDetails = courseRepository.getByCourseName(name);
            if (courseDetails.isEmpty()) {
                System.out.println("List is empty");
            }

            for (CourseEntity entity : courseDetails) {
                CourseModel model = new CourseModel();
                model.mapEntityToModel(entity);
                courseModelList.add(model);
            }
            return courseModelList;

        }catch (RuntimeException ex){
            throw new RuntimeException("Does not find the course!!!!");
        }

    }




}
