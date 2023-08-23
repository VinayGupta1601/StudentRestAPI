package final_spring_boot_project.entity;

import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "student")
public class Student {

    @Id
    @Column(name = "roll")
    //@GeneratedValue(strategy = GenerationType.AUTO)
    private int roll;

    @Column(name = "name")
    private String name;

    @Column(name = "city")
    private String city;
}
