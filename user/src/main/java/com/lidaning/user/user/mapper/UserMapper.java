package com.lidaning.user.user.mapper;

import com.lidaning.user.user.domain.User;

import java.util.List;
public interface UserMapper {

    public User selectUserById(String id);

    public List<User> selectUserList(User user);

    public int insertUser(User user);

    public int updateUser(User user);

    public int deleteUserById(String id);

    public int deleteUserByIds(String[] ids);
}