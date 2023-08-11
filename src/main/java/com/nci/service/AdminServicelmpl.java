package com.nci.service;

import com.nci.pojo.Admin;
import com.nci.mapper.AdminMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminServicelmpl implements AdminService {

    @Autowired
    private AdminMapper adminMapper;


    @Override
    public Admin adminLogin(Admin admin) {
        return adminMapper.getByUsernameAndPassword(admin);
    }

}
