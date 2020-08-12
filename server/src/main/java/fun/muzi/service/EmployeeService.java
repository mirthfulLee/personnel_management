package fun.muzi.service;

import fun.muzi.entity.Employee;
import fun.muzi.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    public Integer update(Employee employee){
        return employeeRepository.update(employee);
    }

    public Integer add(Employee employee) {
        return employeeRepository.add(employee);
    }

    public Employee getByPhone(String phone) {
        return employeeRepository.getByPhone(phone);
    }

    public Integer deleteByPhone(String  phone){
        return employeeRepository.deleteByPhone(phone);
    }
}
