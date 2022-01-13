package com.lidaning.goods.goods.service;

import com.lidaning.goods.goods.domain.StorageTbl;

import java.util.List;

public interface IStorageTblService{

    public StorageTbl selectStorageTblById(String id);

    public List<StorageTbl> selectStorageTblList(StorageTbl storageTbl);

    public int insertStorageTbl(StorageTbl storageTbl);

    public int updateStorageTbl(StorageTbl storageTbl);

    public int deleteStorageTblByIds(String[] ids);

    public int deleteStorageTblById(String id);
}