package com.sms.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.sms.exception.StudentException;
import com.sms.model.Student;
import com.sms.model.StudentDTO;
import com.sms.repository.StudentRepo;

@Service
public class StudentServiceImp implements StudentService {

	@Autowired
    private StudentRepo studentRepo;
	
	// Basic CRUD Operation
	@Override
	public Student saveStudent(Student student)throws StudentException {
		// TODO Auto-generated method stub
		if(student ==null) {
			throw new StudentException("Student not registered");
			
		}else {
		studentRepo.save(student);
		}
		return student;
	}

	@Override
	public Student getStudentById(Integer id)throws StudentException {
		// TODO Auto-generated method stub
		Optional<Student> student = studentRepo.findById(id);

		return student.orElseThrow(() -> new StudentException("Student not found"));
	
	}
	
    @Override
	public Student updateStudent(Student student) throws StudentException{
		// TODO Auto-generated method stub
		Optional<Student> opt = studentRepo.findById(student.getId());
		if (opt.isPresent()) {
			studentRepo.save(student);
			
		} else {
			throw new StudentException("Student not found");
		}
		return student;
	}
	
    @Override
	public Student deleteStudentById(Integer Id) throws StudentException{
		// TODO Auto-generated method stub
		Optional<Student> opt = studentRepo.findById(Id);
		if (opt.isPresent()) {
			studentRepo.delete(opt.get());
		} else {
			throw new StudentException("Student not found");
		}
		return opt.get();
	}
	
    @Override
	public List<Student> getAllStudent() throws StudentException{
		// TODO Auto-generated method stub
		List<Student> list = studentRepo.findAll();
		if (list.size() == 0) {
			throw new StudentException("No any Student Found");
		}
		return list;
	}

       
	@Override       // Update Only Marks
	public Student updateStudentMarks(Integer id, Integer graceMarks) throws StudentException {
		// TODO Auto-generated method stub
		Optional<Student> opt = studentRepo.findById(id);
		
		if (opt.isPresent()) {
			opt.get().setMarks(opt.get().getMarks() + graceMarks);
			studentRepo.save(opt.get());
		} else {
			throw new StudentException("Student not found");
		}
		return opt.get();
	}

	@Override       // find Student by marks
	public List<Student> getStudentByMarks(Integer marks) throws StudentException {
		// TODO Auto-generated method stub
		List<Student> students = studentRepo.findByMarks(marks);
	    
		if(students.size() == 0) {
			throw new StudentException("No Student Found");
		}else {
			return students;
		}
	}

	@Override        // find Student by Name
	public List<Student> getStudentByName(String name) throws StudentException {
		// TODO Auto-generated method stub
        List<Student> students = studentRepo.findByName(name);
	    
		if(students.size() == 0) {
			throw new StudentException("No Student Found");
		}else {
			return students;
		}
	}

	@Override        // find Student, by Name And Marks
	public List<Student> getStudentByNameAndMarks(String name, Integer marks) throws StudentException {
		// TODO Auto-generated method stub
        List<Student> students = studentRepo.findByNameAndMarks(name, marks);
	    
		if(students.size() == 0) {
			throw new StudentException("No Student Found with same roll and marks");
		}else {
			return students;
		}
	}

	@Override       // find student by  Name Or marks
	public List<Student> getStudentByNameOrMarks(String name, Integer marks) throws StudentException {
		// TODO Auto-generated method stub
		List<Student> students = studentRepo.findByNameOrMarks(name, marks);
	    
		if(students.size() == 0) {
			throw new StudentException("No Student Found with same roll or marks");
		}else {
			return students;
		}
	}

	@Override       // Find Students GreaterThen Marks
	public List<Student> getAllStudentGreaterThenMarks(Integer marks) throws StudentException {
		// TODO Auto-generated method stub
		List<Student> students = studentRepo.findByMarksGreaterThan(marks);
			    
		if(students.size() == 0) {
			throw new StudentException("No Student Found");
		}else {
			return students;
		}
	}
	
	// Find Top 3 Student By marks in OrderBy
	@Override
	public List<Student> getTopThreeStudent() {
		// TODO Auto-generated method stub
		List<Student> students = studentRepo.findTop3ByOrderByMarksDesc();
	    
		if(students.size() == 0) {
			throw new StudentException("No Student Found");
		}else {
			return students;
		}
	}
	
    // Method Using Query
	@Override       // Find Only Student Name By Marks
	public String getStudentNameByRoll(Integer roll) throws StudentException {
		
	   String name= studentRepo.getNameByRoll(roll);
		
		if(name != null) {
			return name;
		}else {
			throw new StudentException("Student not found with with this roll");
		}
	 }

	@Override       // Find Only Student Name And Marks By Address
	public List<String> getStudentNameAndMarksByAddress(String address) throws StudentException {
		// TODO Auto-generated method stub
		List<String> results = studentRepo.getNameAndMarksByAddress(address);
		
		if(results.size() != 0) {
			return results;
		}else {
			throw new StudentException("Student not found with with this Address");
		}
	}

	@Override      // using StudentDTO class Find Only Student Name And Marks By Address     
	public List<StudentDTO> getStudentNameAndMarksByAddress2(String address) throws StudentException {
		// TODO Auto-generated method stub
        List<StudentDTO> results = studentRepo.getNameAndMarksByAddress2(address);
		
		if(results.size() != 0) {
			return results;
		}else {
			throw new StudentException("Student not found with with this Address");
		}
	}

	
	
	

}
