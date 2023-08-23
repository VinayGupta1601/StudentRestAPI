package final_spring_boot_project.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import final_spring_boot_project.entity.Student;

public interface StudentDAO extends JpaRepository<Student,Integer>{

	
}
