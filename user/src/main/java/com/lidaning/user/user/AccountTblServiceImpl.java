package com.lidaning.user.user;

import java.util.List;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;

@Service
public class AccountTblServiceImpl implements IAccountTblService{
    @Resource
    private AccountTblMapper accountTblMapper;

    @Override
    public AccountTbl selectAccountTblById(String id){
        return accountTblMapper.selectAccountTblById(id);
    }

    @Override
    public List<AccountTbl> selectAccountTblList(AccountTbl accountTbl){
        return accountTblMapper.selectAccountTblList(accountTbl);
    }

    @Override
    public int insertAccountTbl(AccountTbl accountTbl){
        return accountTblMapper.insertAccountTbl(accountTbl);
    }

    @Override
    public int updateAccountTbl(AccountTbl accountTbl){
        return accountTblMapper.updateAccountTbl(accountTbl);
    }

    @Override
    public int deleteAccountTblByIds(String[] ids){
        return accountTblMapper.deleteAccountTblByIds(ids);
    }

    @Override
    public int deleteAccountTblById(String id){
        return accountTblMapper.deleteAccountTblById(id);
    }
}