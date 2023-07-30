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

    /**
     * add new quote
     * @param quote
     */
    @Insert("insert into quote(name,phone,message ) " +
            "values(#{name}),#{phone},#{message})")
    void insert(Quote quote);
}
