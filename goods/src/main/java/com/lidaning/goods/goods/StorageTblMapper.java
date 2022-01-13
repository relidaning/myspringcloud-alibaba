package com.lidaning.goods.goods;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface StorageTblMapper {

    public StorageTbl selectStorageTblById(String id);

    public List<StorageTbl> selectStorageTblList(StorageTbl storageTbl);

    public int insertStorageTbl(StorageTbl storageTbl);

    public int updateStorageTbl(StorageTbl storageTbl);

    public int deleteStorageTblById(String id);

    public int deleteStorageTblByIds(String[] ids);
}