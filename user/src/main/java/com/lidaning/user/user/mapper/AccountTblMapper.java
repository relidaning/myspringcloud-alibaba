package com.lidaning.user.user.mapper;

import java.util.List;

import com.lidaning.user.user.domain.AccountTbl;

public interface AccountTblMapper {

    public AccountTbl selectAccountTblById(String id);

    public List<AccountTbl> selectAccountTblList(AccountTbl accountTbl);

    public int insertAccountTbl(AccountTbl accountTbl);

    public int updateAccountTbl(AccountTbl accountTbl);

    public int deleteAccountTblById(String id);

    public int deleteAccountTblByIds(String[] ids);
}