package fun.muzi;

import fun.muzi.service.DepartmentService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ApplicationTests {

    @Test
    void contextLoads() {
        DepartmentService departmentService = new DepartmentService();
        System.out.println(departmentService.getEmployees(1));
    }

}
