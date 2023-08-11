package com.nci.mapper;

import com.nci.pojo.Quote;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface QuoteMapper {

    @Select("select * from quote")
    @Results({
            @Result(property="submitTime",column="submit_time"),
    })
    List<Quote> list();

    /**
     * add new quote
     * @param quote
     * @return
     */
    @Insert("insert into quote(name, email,phone, message, submit_time) " +
            "values(#{name},#{email}, #{phone}, #{message}, #{submitTime})")
    void insert(Quote quote);

    /**
     * delete quote
     * @param id
     */
    @Delete("delete from quote where id = #{id}")
    void deleteById(Integer id);


}
