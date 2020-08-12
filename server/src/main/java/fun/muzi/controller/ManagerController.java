package fun.muzi.controller;


import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import fun.muzi.entity.Department;
import fun.muzi.entity.Employee;
import fun.muzi.entity.Manager;
import fun.muzi.service.ManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/manager")
public class ManagerController {

    @Autowired
    private ManagerService managerService;

    @RequestMapping("/add")
    public Integer add(@RequestBody Manager manager) {
        Integer result = managerService.add(manager);
        return result;
    }

    @RequestMapping("/update")
    public Integer update(@RequestBody Manager manager) {
        Integer result = managerService.update(manager);
        return result;
    }

    @RequestMapping("/getByPhone")
    public Manager getByPhone(@RequestBody Map<String,String> req) {
        String phone = req.get("phone");
        return managerService.getByPhone(phone);
    }

    @RequestMapping("/getDepartments")
    public PageInfo<Department> getDepartments(@RequestBody Map<String ,String> req) {
        Integer pageNo=Integer.parseInt(req.get("pageNo"));
        Integer pageSize = Integer.parseInt(req.get("pageSize"));
        String manager = req.get("manager");
        PageHelper.startPage(pageNo, pageSize);
        PageInfo<Department> pageInfo = new PageInfo<>(managerService.getDepartments(manager));
        return pageInfo;
    }
}
