package fun.muzi.service;


import com.github.pagehelper.Page;
import fun.muzi.entity.Department;
import fun.muzi.entity.Manager;
import fun.muzi.repository.ManagerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ManagerService {

    @Autowired
    private ManagerRepository managerRepository;

    public Manager getByPhone(String  phone) {
        return managerRepository.getByPhone(phone);
    }

    public Integer update(Manager manager) {
        return managerRepository.update(manager);
    }

    public Integer add(Manager manager) {
        return managerRepository.add(manager);
    }

    public Page<Department> getDepartments(String manager) {
        return managerRepository.getDepartments(manager);
    }
}
