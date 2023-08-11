package com.nci.Junit;

import com.nci.service.EmpService;
import jakarta.annotation.Resource;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class EmpServiceImplTest {

    @Resource
    private EmpService empService;



}
