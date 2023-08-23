package final_spring_boot_project.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import final_spring_boot_project.entity.Student;
import final_spring_boot_project.service.StudentService;

@RestController("students")
public class StudentController {

	Logger logger = LoggerFactory.getLogger(StudentController.class);


	@Autowired
	private StudentService studentService;

	@PostMapping("/student/add")
	public String addStudent(@RequestBody Student student) {
		logger.info("Inside add Student Post Mapping");
		return studentService.addStudent(student);
	}

	@PostMapping("/student/addAll")
	public String addAllStudents(@RequestBody List<Student> students) {

		return studentService.addAllStudents(students);
	}

	@DeleteMapping("/student/{roll}")
	public String deleteStudent(@PathVariable int roll) {

		return studentService.deleteStudent(roll);
	}

	@PutMapping("/student")
	public String updateStudent(@RequestBody Student student) {

		return studentService.updateStudent(student);
	}

	@GetMapping("/student/{roll}")
	public Student getStudent(@PathVariable int roll) {

		return studentService.getStudent(roll);
	}

	@GetMapping("/student")
	public List<Student> getAllStudents()
	{
		logger.info("Inside get All Students!!");
		return studentService.getAllStudents();
	}
}
