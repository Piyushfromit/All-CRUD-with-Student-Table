package com.sms.controller;



import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


import com.sms.model.Student;
import com.sms.model.StudentDTO;
import com.sms.service.StudentService;

@RestController
public class StudentController {
	
	@Autowired
	private StudentService studentService;
	
	// Simple CRUD Operation
	
	@PostMapping("/student")
	public ResponseEntity<Student> saveStudent(@RequestBody Student student) {

		Student stu = studentService.saveStudent(student);
        return new ResponseEntity<Student>(stu, HttpStatus.CREATED);
		
	}
	
	@GetMapping("/student/{id}")
	public ResponseEntity<Student> getStudentById(@PathVariable("id") Integer stuId) {
		
		Student stu = studentService.getStudentById(stuId);
		return new ResponseEntity<Student>(stu, HttpStatus.OK);
	}
	
	@PutMapping("/student")
	public ResponseEntity<Student> updateStudent(@RequestBody Student newStudent){
		
		Student student = studentService.updateStudent(newStudent);
		return new ResponseEntity<Student>(student, HttpStatus.CREATED);
	}
	
	@DeleteMapping("/student/{id}")
	public ResponseEntity<Student> deleteStudent(@PathVariable("id") Integer stuId){
		
		Student student = studentService.deleteStudentById(stuId);
		return new ResponseEntity<Student>(student, HttpStatus.CREATED);
	}
	
	@GetMapping("/students")
	public ResponseEntity<List<Student>> getAllStudent(){
		
		List<Student> students = studentService.getAllStudent();
		return new ResponseEntity<List<Student>>(students, HttpStatus.CREATED);
	}
	
	// Add grace marks
	@PutMapping("/student/{id}/{graceMarks}")
	public ResponseEntity<Student> updateStudentMarks(@PathVariable("id") Integer stuId, @PathVariable("graceMarks") Integer extraMarks){
		
        Student student = studentService.updateStudentMarks(stuId, extraMarks);
		
		 return new ResponseEntity<Student>(student, HttpStatus.CREATED);
	}
	
	// find Student by marks
	@GetMapping("/getstudentsbymarks/{marks}")
	public ResponseEntity<List<Student>> findStudentsByMarks(@PathVariable("marks") Integer searchmarks) {
		
		List<Student> students = studentService.getStudentByMarks(searchmarks);
		
		return new ResponseEntity<List<Student>>(students, HttpStatus.OK);
		
	}
	
	// find Student by Name
	@GetMapping("/getstudentsbyname/{name}")
	public ResponseEntity<List<Student>> findStudentsByName(@PathVariable("name") String searchname) {
		
		List<Student> students = studentService.getStudentByName(searchname);
		
		return new ResponseEntity<List<Student>>(students, HttpStatus.OK);
		
	}
	
	// find Student by Name And Marks
	@GetMapping("/getstudentsbynameandmarks/{name}/{marks}")
	public ResponseEntity<List<Student>> findStudentsByNameAndMarks(@PathVariable("name") String searchname, @PathVariable("marks") Integer searchmarks) {
		
		List<Student> students = studentService.getStudentByNameAndMarks(searchname, searchmarks);
		
		return new ResponseEntity<List<Student>>(students, HttpStatus.OK);
		
	}
	
	// find Student by Name Or Marks
	@GetMapping("/getstudentsbynameormarks/{name}/{marks}")
	public ResponseEntity<List<Student>> findStudentsByNameOrMarks(@PathVariable("name") String searchname, @PathVariable("marks") Integer searchmarks) {
		
		List<Student> students = studentService.getStudentByNameOrMarks(searchname, searchmarks);
		
		return new ResponseEntity<List<Student>>(students, HttpStatus.OK);
		
	}
	
	
	// Find Students GreaterThen Marks
	@GetMapping("/getstudentsgreaterthenmarks/{marks}")
	public ResponseEntity<List<Student>> findStudentsGreaterThenMarks(@PathVariable("marks") Integer greaterThenMarks) {
		
		List<Student> students = studentService.getAllStudentGreaterThenMarks(greaterThenMarks);
		
		return new ResponseEntity<List<Student>>(students, HttpStatus.OK);
		
	}
	
	// Find Top 3 Student By marks in OrderBy
	@GetMapping("/gettopthreestudent")
	public ResponseEntity<List<Student>> findTopThreeStudent() {
			
		List<Student> students = studentService.getTopThreeStudent();
			
		return new ResponseEntity<List<Student>>(students, HttpStatus.OK);
			
	}
	
	// Find Only Student Name By Marks
	@GetMapping("/getname/{roll}")
	public ResponseEntity<String> fintAStudentNameByRoll(@PathVariable("roll") Integer r){
		
		String name = studentService.getStudentNameByRoll(r);
		
		return new ResponseEntity<String>(name, HttpStatus.OK);
	}
	
	// Find Only Student Name And Marks By Address
	@GetMapping("/getnameandmarksbyaddress/{address}")
	public ResponseEntity<List<String>> fintStudentNameAndMarksByAddress(@PathVariable("address") String address){
		
		List<String> results = studentService.getStudentNameAndMarksByAddress(address);
		
		return new ResponseEntity<List<String>>(results, HttpStatus.OK);
	}
	
	// using StudentDTO class Find Only Student Name And Marks By Address
	@GetMapping("/getnameandmarksbyaddressDTO/{address}")
	public ResponseEntity<List<StudentDTO>> fintStudentNameAndMarksByAddress2DTO(@PathVariable("address") String address){
		
		List<StudentDTO> results = studentService.getStudentNameAndMarksByAddress2(address);
		
		return new ResponseEntity<List<StudentDTO>>(results, HttpStatus.OK);
	}
	
}
