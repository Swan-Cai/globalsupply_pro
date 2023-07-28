package com.nci.controller;

import com.nci.pojo.Dept;
import com.nci.pojo.Result;
import com.nci.service.DeptService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/depts")
public class DeptController {
    //    private  static Logger log = LoggerFactory.getLogger(DeptController.class);
    @Autowired
    private DeptService deptService;

    /**
     * search
     * @return
     */

    @GetMapping
    public Result list(){
        log.info("search all the dept data");

        //call the service for the search dept data
        List<Dept> deptList = deptService.list();
        return Result.success(deptList);
    }

    /**
     * delete
     * @param id
     * @return
     */
    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Integer id){
        log.info("by the id delete department:{}",id);
        //Invoke service delete department
        deptService.delete(id);
        return Result.success();
    }

    /**
     * add department
     * @return
     */
    @PostMapping
    public  Result add(@RequestBody Dept dept){
        log.info("Create department:{}",dept);
        //invoke service
        deptService.add(dept);
        return Result.success();
    }

    /**
     * edit department
     * @return
     */
//    @PutMapping("/{id}")
//    public Result edit(@PathVariable Integer id){
//        log.info("edit department:{}",id);
//        //invoke service
//        deptService.edit(id);
//        return Result.success();
//    }
}