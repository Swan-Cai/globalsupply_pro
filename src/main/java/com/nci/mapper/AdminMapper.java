package com.nci.mapper;

import com.nci.pojo.Admin;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface AdminMapper {

    /**
     * admin
     * @param admin
     * @return
     */

    @Select("select * from admin where username = #{username} and password = #{password}")
    Admin getByUsernameAndPassword(Admin admin);
}
