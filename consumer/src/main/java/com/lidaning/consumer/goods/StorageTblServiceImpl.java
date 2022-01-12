package com.lidaning.consumer.goods;

import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class StorageTblServiceImpl implements IStorageTblService{
    @Resource
    private StorageTblMapper storageTblMapper;

    @Override
    public StorageTbl selectStorageTblById(String id){
        return storageTblMapper.selectStorageTblById(id);
    }

    @Override
    public List<StorageTbl> selectStorageTblList(StorageTbl storageTbl){
        return storageTblMapper.selectStorageTblList(storageTbl);
    }

    @Override
    public int insertStorageTbl(StorageTbl storageTbl){
        return storageTblMapper.insertStorageTbl(storageTbl);
    }

    @Override
    public int updateStorageTbl(StorageTbl storageTbl){
        return storageTblMapper.updateStorageTbl(storageTbl);
    }

    @Override
    public int deleteStorageTblByIds(String[] ids){
        return storageTblMapper.deleteStorageTblByIds(ids);
    }

    @Override
    public int deleteStorageTblById(String id){
        return storageTblMapper.deleteStorageTblById(id);
    }
}