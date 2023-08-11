package com.nci.Junit;

import com.nci.mapper.DeptMapper;
import com.nci.pojo.Dept;
import com.nci.service.DeptServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@SpringBootTest
public class DeptServiceImplTest {

    @Mock
    private DeptMapper deptMapper;

    @InjectMocks
    private DeptServiceImpl deptService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testList() {
        // 准备Prepare
        List<Dept> expectedList = new ArrayList<>();
        when(deptMapper.list()).thenReturn(expectedList);

        // 执行execute
        List<Dept> actualList = deptService.list();

        // 断言verify
        assertEquals(expectedList, actualList);
        verify(deptMapper, times(1)).list();
    }

    @Test
    public void testDelete() {
        // 准备 Prepare
        Integer id = 1;

        // 执行 execute
        deptService.delete(id);

        // 断言 verify
        verify(deptMapper, times(1)).deleteById(id);
    }

    @Test
    public void testAdd() {
        // 准备
        Dept dept = new Dept();

        // 执行
        deptService.add(dept);

        // 断言
        verify(deptMapper, times(1)).insert(dept);
    }

    @Test
    public void testEdit() {
        // 准备
        Integer id = 1;
        String name = "newProduct";

        // 执行
        deptService.edit(id, name);

        // 断言
        verify(deptMapper, times(1)).edit(id, name);
    }
}
