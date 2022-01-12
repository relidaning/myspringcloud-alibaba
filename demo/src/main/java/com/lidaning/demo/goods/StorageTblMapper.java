package com.lidaning.demo.goods;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface StorageTblMapper {

    public StorageTbl selectStorageTblById(String id);

    public List<StorageTbl> selectStorageTblList(StorageTbl storageTbl);

    public int insertStorageTbl(StorageTbl storageTbl);

    public int updateStorageTbl(StorageTbl storageTbl);

    public int deleteStorageTblById(String id);

    public int deleteStorageTblByIds(String[] ids);
}