package com.lidaning.demo.undo;

import java.util.List;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;

@Service
public class UndoLogServiceImpl implements IUndoLogService{
    @Resource
    private UndoLogMapper undoLogMapper;

    @Override
    public UndoLog selectUndoLogById(String id){
        return undoLogMapper.selectUndoLogById(id);
    }

    @Override
    public List<UndoLog> selectUndoLogList(UndoLog undoLog){
        return undoLogMapper.selectUndoLogList(undoLog);
    }

    @Override
    public int insertUndoLog(UndoLog undoLog){
        return undoLogMapper.insertUndoLog(undoLog);
    }

    @Override
    public int updateUndoLog(UndoLog undoLog){
        return undoLogMapper.updateUndoLog(undoLog);
    }

    @Override
    public int deleteUndoLogByIds(String[] ids){
        return undoLogMapper.deleteUndoLogByIds(ids);
    }

    @Override
    public int deleteUndoLogById(String id){
        return undoLogMapper.deleteUndoLogById(id);
    }
}