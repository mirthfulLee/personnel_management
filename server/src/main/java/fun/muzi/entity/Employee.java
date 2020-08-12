package fun.muzi.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Component
public class Employee {

    private String name;
    private Integer gender;
    private String  phone;
    private String education;
    private Date hiredate;
    private Integer department;
    private Integer workingHours;
    private Integer overtimeHours;
    private String position;
    private String password;

}
