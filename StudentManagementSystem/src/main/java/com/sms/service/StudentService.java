package com.sms.service;



import java.util.List;

import com.sms.exception.StudentException;
import com.sms.model.Student;
import com.sms.model.StudentDTO;

public interface StudentService {
	
	
	// Simple CRUD operation
	public Student saveStudent(Student student)throws StudentException;
	
	public Student getStudentById(Integer id)throws StudentException;
	
	public Student updateStudent(Student student)throws StudentException;

	public Student deleteStudentById(Integer customerId)throws StudentException;
	
	public List<Student> getAllStudent()throws StudentException;
	
	
	// Update Only Marks
	public Student updateStudentMarks(Integer id, Integer graceMarks) throws StudentException;
	
	// find Student by marks
	public List<Student> getStudentByMarks(Integer marks) throws StudentException;
	
	// find Student by Name
	public List<Student> getStudentByName(String name) throws StudentException;
	
	// find Student, by Name And Marks
	public List<Student> getStudentByNameAndMarks(String name, Integer marks) throws StudentException;
	
	// find student by  Name Or marks
	public List<Student> getStudentByNameOrMarks(String name, Integer marks) throws StudentException;

	
	// Find Students GreaterThen Marks
	public List<Student> getAllStudentGreaterThenMarks(Integer marks) throws StudentException;

	// Find Top 3 Student By marks in OrderBy
	public List<Student> getTopThreeStudent();
	
	// Method Using Query
	// Find Only Student Name By Marks
    public String getStudentNameByRoll(Integer roll) throws StudentException ;
	
   // Find Only Student Name And Marks By Address
    public List<String> getStudentNameAndMarksByAddress(String address) throws StudentException ;
    
    // using StudentDTO class Find Only Student Name And Marks By Address
    public List<StudentDTO> getStudentNameAndMarksByAddress2(String address) throws StudentException ;
    


}
