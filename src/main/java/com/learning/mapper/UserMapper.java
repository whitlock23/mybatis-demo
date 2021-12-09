package com.learning.mapper;

import com.learning.pojo.User;

import java.util.List;

/**
 * @Classname UserMapper
 * @Description proxy mapper
 * @Date 2021/12/7 2:05 下午
 * @Created by whitlock23
 */
public interface UserMapper {
    List<User> selectAll();
}
