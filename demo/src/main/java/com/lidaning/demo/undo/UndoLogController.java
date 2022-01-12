package com.lidaning.demo.undo;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.supervise.common.annotation.Log;
import com.supervise.common.enums.BusinessType;
import com.supervise.common.core.controller.BaseController;
import com.supervise.common.core.domain.AjaxResult;
import com.supervise.common.core.page.TableDataInfo;


@RestController
@RequestMapping("/undo/undoLog")
public class UndoLogController extends BaseController{
    @Autowired
    private IUndoLogService undoLogService;

    @GetMapping("/list")
    public TableDataInfo list(UndoLog undoLog){
        startPage();
        List<UndoLog> list = undoLogService.selectUndoLogList(undoLog);
        return getDataTable(list);
    }

    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") String id){
        return AjaxResult.success(undoLogService.selectUndoLogById(id));
    }

    @Log(title = "", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody UndoLog undoLog){
        return toAjax(undoLogService.insertUndoLog(undoLog));
    }

    @Log(title = "", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody UndoLog undoLog){
        return toAjax(undoLogService.updateUndoLog(undoLog));
    }

    @Log(title = "", businessType = BusinessType.DELETE)
    @DeleteMapping
    public AjaxResult remove(@PathVariable String[] ids){
        return toAjax(undoLogService.deleteUndoLogByIds(ids));
    }
}