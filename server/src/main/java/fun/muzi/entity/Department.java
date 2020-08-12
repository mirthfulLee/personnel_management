package fun.muzi.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Component
@ConfigurationProperties(prefix = "department")
public class Department {
    private Integer id;
    private String name;
    private String chief;
    private String manager;
    private Double salaryPerHour;
    private Double overtimePayPerHour;
}
