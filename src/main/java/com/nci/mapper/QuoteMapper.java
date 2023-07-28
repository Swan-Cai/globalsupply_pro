package com.nci.mapper;

import com.nci.pojo.Quote;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface QuoteMapper {

    @Select("select * from quote")
    List<Quote> list();

//    @Insert(insert into quote(name, tel, ))
//    void insert(Quote quote);
}
