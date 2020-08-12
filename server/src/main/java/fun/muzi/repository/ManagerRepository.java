package fun.muzi.repository;

import com.github.pagehelper.Page;
import fun.muzi.entity.Department;
import fun.muzi.entity.Manager;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface ManagerRepository {

    Manager getByPhone(String  phone);

    Integer update(Manager manager);

    Integer add(Manager manager);

    Page<Department> getDepartments(String manager);
}
