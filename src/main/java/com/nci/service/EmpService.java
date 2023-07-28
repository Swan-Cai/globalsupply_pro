package com.nci.service;

import com.nci.pojo.Emp;
import com.nci.pojo.PageBean;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.util.List;

public interface EmpService {
    /**
     * page query
     * @param page
     * @param pageSize
     * @return
     */
    PageBean page(Integer page, Integer pageSize,String name, Short gender, LocalDate begin, LocalDate end);

    /**
     * mutiple delete
     * @param ids
     */
    void delete(List<Integer> ids);

    /**
     * create new employee
     * @param emp
     */
    void save(Emp emp);

    /**
     * research by ID
     * @param id
     * @return
     */
    Emp getById(Integer id);


    void update(Emp emp);

    Emp login(Emp emp);
}
