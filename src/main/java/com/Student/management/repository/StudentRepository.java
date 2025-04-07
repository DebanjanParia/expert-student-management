package com.Student.management.repository;

import com.Student.management.entity.StudentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<StudentEntity, Long> {


    @Query(value = "select * from student_details where student_id = :studentId", nativeQuery = true)
    public StudentEntity findByStudentId(long studentId);

    @Query(value = "delete from student_details where student_id = :studentId", nativeQuery = true)
    public void deleteByStudentId(long studentId);

    @Query
    public boolean existsByStudentId(long studentId);

    @Query(value = "select * from student_details where passing_year = :passingYear", nativeQuery = true)
    public List<StudentEntity> sortByPassingYear(int passingYear);

    @Query(value = "select * from student_details where registration_year = :registrationYear", nativeQuery = true)
    public List<StudentEntity> sortByRegistrationYear(int registrationYear);


}
