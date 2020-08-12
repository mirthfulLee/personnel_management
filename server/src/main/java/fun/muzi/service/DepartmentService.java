package fun.muzi.service;

import com.github.pagehelper.Page;
import fun.muzi.entity.Department;
import fun.muzi.entity.Employee;
import fun.muzi.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DepartmentService {

    @Autowired
    private DepartmentRepository departmentRepository;

    public Integer add(Department department){
        return departmentRepository.add(department);
    }

    public Integer deleteByName(String name){
        return departmentRepository.deleteByName(name);
    }

    public Integer deleteById(Integer id) {
        return departmentRepository.deleteById(id);
    }

    public Integer update(Department department){
        return departmentRepository.update(department);
    }

    public Department getByName(String name){
        return departmentRepository.getByName(name);
    }

    public Department getById(Integer id) {
        return departmentRepository.getById(id);
    }

    public Page<Employee> getEmployees(Integer id){
        return departmentRepository.getEmployees(id);
    }
}
