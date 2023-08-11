package com.nci.service;

import com.nci.pojo.Admin;
import org.springframework.stereotype.Service;

@Service
public interface AdminService {

    Admin adminLogin(Admin admin);
}
