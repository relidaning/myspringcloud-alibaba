package com.lidaning.user.user;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserMapper {

    public User selectUserById(String id);

    public List<User> selectUserList(User user);

    public int insertUser(User user);

    public int updateUser(User user);

    public int deleteUserById(String id);

    public int deleteUserByIds(String[] ids);
}