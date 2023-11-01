package final_spring_boot_project.service;

import java.util.List;

import final_spring_boot_project.dao.StudentDAO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import final_spring_boot_project.entity.Student;

@Slf4j
@Service
public class StudentService {

    @Autowired
    private StudentDAO studentDAO;

    public Student addStudent(Student student) {
        log.info("Inside addStudent method.");
        studentDAO.save(student);
        //log.info("Student Saved.");
        return student;
    }

    public List<Student> addAllStudents(List<Student> students) {
        log.info("Inside addAllStudents method.");
        studentDAO.saveAll(students);
        return students;
    }

    public Student deleteStudent(int roll) {
        log.info("Inside deleteStudent by roll method.");
        Student student = studentDAO.getById(roll);
        studentDAO.delete(student);
        return student;
    }

    public Student updateStudent(Student student) {
        log.info("Inside updateStudent method.");
        studentDAO.save(student);
        return student;
    }

    public Student getStudent(int roll) {
        log.info("Inside getStudent by roll method.");
        return studentDAO.findById(roll).orElse(null);
    }

    public List<Student> getAllStudents() {
        log.info("Inside getAllStudents method.");
        return studentDAO.findAll();
    }
}
