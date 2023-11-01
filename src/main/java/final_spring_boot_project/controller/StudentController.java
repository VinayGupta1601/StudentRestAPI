package final_spring_boot_project.controller;

import java.util.List;
import java.util.Optional;

import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import final_spring_boot_project.entity.Student;
import final_spring_boot_project.service.StudentService;

@RestController("students")
@RequestMapping("/api")
public class StudentController {

	Logger logger = LoggerFactory.getLogger(StudentController.class);


	@Autowired
	private StudentService studentService;

	@PostMapping("/student/add")
	@ApiOperation(value = "Add an students in the database!!",notes = "Do not Provide ant ID",response = Student.class)
	public ResponseEntity<Student> addStudent(@RequestBody Student student) {
		logger.info("Inside add Student Post Mapping");
		try
		{
			Student stud = studentService.addStudent(student);
			return ResponseEntity.of(Optional.of(stud));
		}
		catch (Exception e)
		{
			//e.printStackTrace();
			logger.info("Error Wile posting",e);
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}

	@PostMapping("/student/addAll")
	@ApiOperation(value = "Add multiple students in the database!!",notes = "Needs a JSON file ",response = Student.class)
	public ResponseEntity<List<Student>> addAllStudents(@RequestBody List<Student> students) {

		try
		{
			List<Student> student = studentService.addAllStudents(students);
			return ResponseEntity.of(Optional.of(student));
		}
		catch (Exception e)
		{
			//e.printStackTrace();
			logger.info("Error Wile posting",e);
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}

	@DeleteMapping("/student/{roll}")
	@ApiOperation(value = "Delete students saved in the database!!",notes = "Need student roll no",response = Student.class)
	public ResponseEntity<Student> deleteStudent(@PathVariable int roll) {

		try
		{
			Student s = studentService.deleteStudent(roll);
			return ResponseEntity.of(Optional.of(s));
		}
		catch (Exception e)
		{
			//e.printStackTrace();
			logger.info("Error Wile deleting",e);
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
	}

	@PutMapping("/student")
	@ApiOperation(value = "Update students detail in the database!!",notes = "Do not Provide any ID",response = Student.class)
	public ResponseEntity<Student> updateStudent(@RequestBody Student student) {

		try {
			Student s1 = studentService.updateStudent(student);
			return ResponseEntity.of(Optional.of(s1));
		}
		catch (Exception e)
		{
			//e.printStackTrace();
			logger.info("Error Wile updating",e);
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
	}

	@GetMapping("/student/{roll}")
	@ApiOperation(value = "Get students detail with roll",notes = "Need Student Roll Number",response = Student.class)
	public ResponseEntity<Student> getStudent(@PathVariable int roll) {
		try
		{
			Student s =  studentService.getStudent(roll);
			return ResponseEntity.of(Optional.of(s));
		}
		catch (Exception e)
		{
			///e.printStackTrace();
			logger.info("Error Wile getting",e);
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
	}

	@GetMapping("/student")
	@ApiOperation(value = "Get All students saved in the database!!",notes = "Do not Provide any ID",response = Student.class)
	public ResponseEntity<List<Student>> getAllStudents()
	{
		logger.info("Inside get All Students!!");
		try
		{
			List<Student>list =  studentService.getAllStudents();
			return ResponseEntity.of(Optional.of(list));
		}
		catch (Exception e)
		{
			//e.printStackTrace();
			logger.info("Error Wile getting",e);
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}

	}
}
