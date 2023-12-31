package final_spring_boot_project.service;

import final_spring_boot_project.dao.StudentDAO;
import final_spring_boot_project.entity.Student;
import final_spring_boot_project.service.StudentService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@SpringBootTest(classes = StudentService.class)
public class StudentServiceTest {

    @MockBean
    private StudentDAO studentDAO;

    @Autowired
    private StudentService studentService;

    private Student student1, student2;

    @BeforeEach
    public void setUp() {
        //MockitoAnnotations.initMocks(studentService);

        student1 = Student.builder()
                .roll(1)
                .city("allahabad")
                .name("vinay")
                .build();

        student2 = Student.builder()
                .roll(2)
                .city("indore")
                .name("Mayur")
                .build();
    }

    @Test
    public void testGetAllStudents() {
        when(studentDAO.findAll()).thenReturn(List.of(student1, student2));

        List<Student> output = studentService.getAllStudents();

        assertThat(output).containsExactlyInAnyOrderElementsOf(List.of(student1, student2));
        verify(studentDAO).findAll();
    }
    @Test
    public void testGetStudents() {
        when(studentDAO.getById(1)).thenReturn(student1);

        Student roll = studentService.getStudent(student1.getRoll());

        assertEquals(1,student1.getRoll());
        //assertThat(output).equals(student1.getRoll());

    }



}
