package com.nci.Junit;

import com.nci.mapper.QuoteMapper;
import com.nci.pojo.Quote;
import jakarta.annotation.Resource;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest
public class QuoteServiceImplTest {
    @Resource
    private QuoteMapper quoteMapper;

    @Test
    void add(){
        Quote q = new Quote();
        q.setName("wan");
        q.setEmail("wanpin@cloud.com");
        q.setPhone("832022222");
        q.setMessage("Hello,I need to know more information about the productC");

        this.quoteMapper.insert(q);

        System.out.println(q.getEmail());
    }



}
