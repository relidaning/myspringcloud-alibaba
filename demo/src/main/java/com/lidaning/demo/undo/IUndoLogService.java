package com.lidaning.demo.undo;

import java.util.List;

public interface IUndoLogService{

    public UndoLog selectUndoLogById(String id);

    public List<UndoLog> selectUndoLogList(UndoLog undoLog);

    public int insertUndoLog(UndoLog undoLog);

    public int updateUndoLog(UndoLog undoLog);

    public int deleteUndoLogByIds(String[] ids);

    public int deleteUndoLogById(String id);
}