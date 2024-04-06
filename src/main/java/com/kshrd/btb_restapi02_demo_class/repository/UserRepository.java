package com.kshrd.btb_restapi02_demo_class.repository;

import com.kshrd.btb_restapi02_demo_class.model.dto.UserDTO;
import com.kshrd.btb_restapi02_demo_class.model.entity.UserApp;
import com.kshrd.btb_restapi02_demo_class.model.request.UserRequest;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface UserRepository {

    @Select("SELECT * FROM user_tb WHERE id = #{userId}")
    UserApp findUserById(Integer userId);

    @Select("SELECT * FROM user_tb")
    List<UserApp> findAllUser();

    @Select("INSERT INTO user_tb (name,email,password,address) " +
            "VALUES (#{request.name}," +
            "#{request.email}," +
            "#{request.password}," +
            "#{request.address}) " +
            "RETURNING id")
    Integer saveUser(@Param("request") UserRequest userRequest);


}
