package com.Student.management.repository;

import com.Student.management.entity.EnrollEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

@Repository
@EnableJpaRepositories
public interface EnrollmentRepository extends JpaRepository<EnrollEntity, Long> {


//    @Query(value = "select * from enrollment where enrollment_id =:studentId")
//    public boolean existsByStudentAndCourse(long studentId);
}
