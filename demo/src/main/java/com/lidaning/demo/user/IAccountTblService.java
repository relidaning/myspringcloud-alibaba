package com.lidaning.demo.user;

import java.util.List;

public interface IAccountTblService{

    public AccountTbl selectAccountTblById(String id);

    public List<AccountTbl> selectAccountTblList(AccountTbl accountTbl);

    public int insertAccountTbl(AccountTbl accountTbl);

    public int updateAccountTbl(AccountTbl accountTbl);

    public int deleteAccountTblByIds(String[] ids);

    public int deleteAccountTblById(String id);
}