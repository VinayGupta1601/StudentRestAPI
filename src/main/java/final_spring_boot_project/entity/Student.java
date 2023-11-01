package final_spring_boot_project.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "student")
@ApiModel(description = "Details about the students")
public class Student {

    @Id
    @Column(name = "roll")
    @ApiModelProperty(notes = "Roll Number of the student")
    //@GeneratedValue(strategy = GenerationType.AUTO)
    private int roll;

    @Column(name = "name")
    @ApiModelProperty(notes = "Name of the student")
    private String name;

    @Column(name = "city")
    @ApiModelProperty(notes = "Student living in the city")
    private String city;
}
