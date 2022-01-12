package com.lidaning.demo.undo;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UndoLogMapper {

    public UndoLog selectUndoLogById(String id);

    public List<UndoLog> selectUndoLogList(UndoLog undoLog);

    public int insertUndoLog(UndoLog undoLog);

    public int updateUndoLog(UndoLog undoLog);

    public int deleteUndoLogById(String id);

    public int deleteUndoLogByIds(String[] ids);
}