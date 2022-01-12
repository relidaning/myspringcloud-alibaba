package com.lidaning.demo.user;

import com.supervise.common.core.domain.AjaxResult;

import java.util.List;

public interface IUserService{

    public User selectUserById(String id);

    public List<User> selectUserList(User user);

    public int insertUser(User user);

    public int updateUser(User user);

    public int deleteUserByIds(String[] ids);

    public int deleteUserById(String id);

    public AjaxResult buy();
}