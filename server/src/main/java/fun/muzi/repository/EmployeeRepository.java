package fun.muzi.repository;

import fun.muzi.entity.Employee;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface EmployeeRepository {
    Integer update(Employee employee);

    Integer add(Employee employee);

    Employee getByPhone(String  phone);

    Integer deleteByPhone(String  phone);
}
