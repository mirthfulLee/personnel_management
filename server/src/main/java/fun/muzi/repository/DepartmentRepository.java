package fun.muzi.repository;

import com.github.pagehelper.Page;
import fun.muzi.entity.Department;
import fun.muzi.entity.Employee;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface DepartmentRepository {
    Integer add(Department department);

    Integer deleteByName(String name);

    Integer deleteById(Integer id);

    Integer update(Department department);

    Department getByName(String name);

    Department getById(Integer id);

    Page<Employee> getEmployees(Integer id);
}
