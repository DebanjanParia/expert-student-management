package com.Student.management.repository;

import com.Student.management.entity.CourseEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CourseRepository extends JpaRepository<CourseEntity, Long> {

    @Query(name = "select * from course_details where course_id =:courseId", nativeQuery = true)
    public CourseEntity getByCourseId(long courseId);

    @Query(value = "select * from course_details where course_name ilike %:name%", nativeQuery = true)
    public List<CourseEntity> getByCourseName( String name);


}
