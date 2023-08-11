package com.nci.mapper;

import com.nci.pojo.Dept;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface DeptMapper {
    /**
     * research all dept data
     * @return
     */
    @Select("select * from dept")
    @Results({
            @Result(property="updateTime",column="update_time"),
    })
    List<Dept> list();

    /**
     * delete department by ide
     * @param id
     */
    @Delete("delete from dept where id = #{id}")
    void deleteById(Integer id);

    /**
     * create department
     * @param dept
     */
    @Insert("insert into dept(name, create_time, update_time) values (#{name},#{createTime},#{updateTime})")
    void insert(Dept dept);

    /**
     * edit the department
     * @param id
     * @param name
     */
    @Update("update dept set name = #{name} where id = #{id}")
    void edit(Integer id, String name);



}
