package com.nci.service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.nci.mapper.EmpMapper;
import com.nci.pojo.Emp;
import com.nci.pojo.PageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class EmpServiceImpl implements EmpService {
    @Autowired
    private EmpMapper empMapper;
//    @Override
//    public PageBean page(Integer page, Integer pageSize) {
//        //1,
//        Long count = empMapper.count();
//        //2
//        Integer start = (page -1) * pageSize;
//        empMapper.page(start,pageSize);
//        List<Emp> empList = empMapper.page(start,pageSize);
//        //3
//        PageBean pageBean = new PageBean(count,empList);
//        return pageBean;

    @Override
    public PageBean page(Integer page, Integer pageSize,String name, Short gender,LocalDate begin,LocalDate end) {
        //1. 设置分页参数
        PageHelper.startPage(page,pageSize);

        //2. 执行查询
        List<Emp> empList = empMapper.list(name, gender, begin, end);
        Page<Emp> p = (Page<Emp>) empList;

        //3. 封装PageBean对象
        PageBean pageBean = new PageBean(p.getTotal(), p.getResult());
        return pageBean;
    }

    /**
     * multiple deltee
     * @param ids
     */
    @Override
    public void delete(List<Integer> ids) {

    }

    @Override
    public void save(Emp emp) {
        emp.setCreateTime(LocalDateTime.now());
        emp.setUpdateTime(LocalDateTime.now());
        empMapper.insert(emp);

    }

    /**
     *
     * @param id
     * @return
     */
    @Override
    public Emp getById(Integer id) {
        return empMapper.getById(id);
    }

    @Override
    public void update(Emp emp) {

        emp.setUpdateTime(LocalDateTime.now());
        empMapper.update(emp);
    }

    /**
     * login
     * @param emp
     * @return
     */
    @Override
    public Emp login(Emp emp) {
        return empMapper.getByUsernameAndPassword(emp);
    }
}
