package com.nci.service;

import com.nci.pojo.Dept;

import java.util.List;

public interface DeptService {
    /**
     * research all dept data
     * @return
     */
    List<Dept> list();


    /**
     * delete department
     * @param id
     */
    void delete(Integer id);

    /**
     * create department
     * @param dept
     */
    void add(Dept dept);

    void edit(Integer id, String name);
}