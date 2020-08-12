package fun.muzi.controller;


import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import fun.muzi.entity.Department;
import fun.muzi.entity.Employee;
import fun.muzi.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/department")
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;

    @RequestMapping("/add")
    public Integer add(@RequestBody Department department) {
        Integer result = departmentService.add(department);
        return result;
    }

    @RequestMapping("/update")
    public Integer update(@RequestBody Department department) {
        Integer result = departmentService.update(department);
        return result;
    }

    @RequestMapping("/delete")
    public Integer delete(@RequestBody Map<String,String> req) {
        Integer id = Integer.parseInt(req.get("id"));
        Integer result = departmentService.deleteById(id);
        return result;
    }

    @RequestMapping("/getById")
    public Department getById(@RequestBody Map<String,String> req) {
        Integer id = Integer.parseInt(req.get("id"));
        return departmentService.getById(id);
    }

    @RequestMapping("/getEmployees")
    public PageInfo<Employee> getEmployees(@RequestBody Map<String,String> req) {
        Integer pageNo=Integer.parseInt(req.get("pageNo"));
        Integer pageSize = Integer.parseInt(req.get("pageSize"));
        Integer id = Integer.parseInt(req.get("id"));
        PageHelper.startPage(pageNo, pageSize);
        PageInfo<Employee> pageInfo = new PageInfo<Employee>(departmentService.getEmployees(id));
        return pageInfo;
    }

}
