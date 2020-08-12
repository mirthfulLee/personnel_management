package fun.muzi.controller;

import fun.muzi.entity.Employee;
import fun.muzi.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @RequestMapping("/add")
    public Integer add(@RequestBody Employee employee) {
        Integer result = employeeService.add(employee);
        return result;
    }

    @RequestMapping("/deleteByPhone")
    public Integer deleteByPhone(@RequestBody Map<String,String> req) {
        String phone = req.get("phone");
        Integer result = employeeService.deleteByPhone(phone);
        return result;
    }

    @RequestMapping("/update")
    public Integer update(@RequestBody Employee employee) {
        Integer result = employeeService.update(employee);
        return result;
    }

    @RequestMapping("/getByPhone")
    public Employee getByPhone(@RequestBody Map<String,String> req) {
        String phone = req.get("phone");
        return employeeService.getByPhone(phone);
    }
}
