package com.example.demo.mapper;

import com.example.demo.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface UserMapper {

    User login(@Param("username") String username,@Param("password") String password);

    User selectUsrMesage(@Param("userId") Long userId);
}
