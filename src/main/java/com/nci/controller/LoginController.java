package com.nci.controller;

import com.nci.pojo.Admin;
import com.nci.pojo.Emp;
import com.nci.pojo.Result;
import com.nci.pojo.User;
import com.nci.service.AdminService;
import com.nci.service.EmpService;
import com.nci.service.UserService;
import com.nci.utils.JwtUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@Slf4j
@RestController
public class LoginController {

    @Autowired
    private EmpService empService;
    @Autowired
    private AdminService adminService;

//    @Autowired
//    private UserService userService;

    /**
     * emplyee login
     * @param emp
     * @return
     */
    @PostMapping("/login")
    public Result login(@RequestBody Emp emp){
        log.info("Employee login: {}", emp);
        Emp e = empService.login(emp);
//        return e != null?Result.success():Result.error("username or password is error");

        //登录成功,生成令牌,下发令牌
        if (e != null) {
            Map<String, Object> claims = new HashMap<>();
            claims.put("id", e.getId());
            claims.put("name", e.getName());
            claims.put("username", e.getUsername());

            String jwt = JwtUtils.generateJwt(claims); //jwt包含了当前登录的员工信息
            return Result.success(jwt);
        }

        //登录失败, 返回错误信息
        return Result.error("username or password is error");
    }

    @PostMapping("/adminLogin")
    public Result adminLogin(@RequestBody Admin admin) {
        log.info("Admin login: {}", admin);
        Admin a = adminService.adminLogin(admin);

        if (a != null) {
            Map<String, Object> claims = new HashMap<>();
            claims.put("id", a.getId());
            claims.put("name", a.getUsername());
//            claims.put("role", "admin");
            String jwt = JwtUtils.generateJwt(claims);
            return Result.success(jwt);
        }

        return Result.error("username or password is error");
    }

//    @PostMapping("/adminLogin")
//    public Result adminLogin(@RequestBody Admin admin) {
//        log.info("Admin login: {}", admin);
//
//        Admin adminFromDB = adminService.findAdminByUsername(admin.getUsername());
//
//        if (adminFromDB != null && new BCryptPasswordEncoder().matches(admin.getPassword(), adminFromDB.getPassword())) {
//            Map<String, Object> claims = new HashMap<>();
//            claims.put("id", adminFromDB.getId());
//            claims.put("name", adminFromDB.getUsername());
//            claims.put("role", "admin");
//
//            String jwt = JwtUtils.generateJwt(claims);
//            return Result.success(jwt);
//        }
//
//        return Result.error("username or password is error");
//    }




//    @PostMapping("/userLogin")
//    public Result userLogin(@RequestBody  User user){
//        log.info("User login: {}", user);
//        User u = userService.userLogin(user);
//
//        //登录成功,生成令牌,下发令牌
//        if (u != null) {
//            Map<String, Object> claims = new HashMap<>();
//            claims.put("id", u.getUid());
//            claims.put("name", u.getUsername());
//            claims.put("password", u.getPassword());
//
//            String jwt = JwtUtils.generateJwt(claims); //jwt包含了当前登录的员工信息
//            return Result.success(jwt);
//        }
//
//        //登录失败, 返回错误信息
//        return Result.error("username or password is error");
//
//    }
}
