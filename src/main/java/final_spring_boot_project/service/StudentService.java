package final_spring_boot_project.service;

import java.util.List;

import final_spring_boot_project.dao.StudentDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import final_spring_boot_project.entity.Student;

@Service
public class StudentService {

    @Autowired
    private StudentDAO studentDAO;

    public String addStudent(Student student) {
        studentDAO.save(student);
        return "Student added:" + student.getRoll();
    }

    public String addStudents(List<Student> students) {
        studentDAO.saveAll(students);
        return "All Student added ";
    }

    public String deleteStudent(int roll) {
        Student student = studentDAO.getById(roll);
        studentDAO.delete(student);
        return "Roll Number deleted :" + roll;
    }

    public String updateStudent(Student student) {
        studentDAO.save(student);
        return "Roll Number Updated :" + student.getRoll();
    }

    public Student getStudent(int roll) {

        return studentDAO.findById(roll).orElse(null);
    }

    public List<Student> getAllStudents() {
        return studentDAO.findAll();
    }
}
