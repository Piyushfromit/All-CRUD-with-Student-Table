package com.sms.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import org.springframework.stereotype.Repository;

import com.sms.model.Student;
import com.sms.model.StudentDTO;


@Repository
public interface StudentRepo extends JpaRepository<Student, Integer>{

	// find Student by marks
	public List<Student> findByMarks(Integer marks);
	
	// find Student by Name
	public List<Student> findByName(String name);
	
	// need to follow method nameing convention
	// find Student by Name And Marks
	public List<Student> findByNameAndMarks(String name, Integer marks);
	
	
	// find student by  Name Or marks
	public List<Student> findByNameOrMarks(String name, Integer marks);
	
	
	// Find Students GreaterThen Marks
	public List<Student> findByMarksGreaterThan(Integer marks);
	
	// Find Top 3 Student By marks in OrderBy
	public List<Student> findTop3ByOrderByMarksDesc();
	
//  Named Query
//  @Query("select s.name from Student s where s.roll=:r")
//	public String getStudentNameByRoll(@Param("r") Integer roll);
	
	// Positional Query, no need to follow method naming convention
	// Find Only Student Name By Marks
	@Query("select s.name from Student s where s.id=?1")   // id is as a roll
	public String getNameByRoll(Integer roll);
	
	// Find Only Student Name And Marks By Address
	@Query("select s.name, s.marks from Student s where s.address=?1")  
	public List<String> getNameAndMarksByAddress(String address);
	
	// using StudentDTO class Find Only Student Name And Marks By Address
	@Query("select new com.sms.model.StudentDTO(s.name, s.marks) from Student s where s.address=?1")  
	public List<StudentDTO> getNameAndMarksByAddress2(String address);


}
