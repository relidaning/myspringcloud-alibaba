package com.lidaning.demo.user;

import java.util.List;

import com.supervise.common.core.domain.AjaxResult;
import io.seata.spring.annotation.GlobalTransactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

@Service
public class UserServiceImpl implements IUserService{
    @Resource
    private UserMapper userMapper;
    @Autowired
    IAccountTblService accountTblService;
    @Autowired
    private RestTemplate restTemplate;

    @Override
    public User selectUserById(String id){
        return userMapper.selectUserById(id);
    }

    @Override
    public List<User> selectUserList(User user){
        return userMapper.selectUserList(user);
    }

    @Override
    public int insertUser(User user){
        return userMapper.insertUser(user);
    }

    @Override
    public int updateUser(User user){
        return userMapper.updateUser(user);
    }

    @Override
    public int deleteUserByIds(String[] ids){
        return userMapper.deleteUserByIds(ids);
    }

    @Override
    public int deleteUserById(String id){
        return userMapper.deleteUserById(id);
    }

    @Transactional
    @GlobalTransactional
    @Override
    public AjaxResult buy() {
        AccountTbl account = accountTblService.selectAccountTblById("1");
        account.setMoney(account.getMoney() - 10*5);
        accountTblService.updateAccountTbl(account);
        String result = restTemplate.getForObject("http://consumer/goods/storageTbl/deceStorage", String.class);
        System.out.println(result);

        return AjaxResult.success();
    }
}