package com.lidaning.user.user.controller;

import java.util.List;

import com.lidaning.user.user.domain.AccountTbl;
import com.lidaning.user.user.service.IAccountTblService;
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
@RequestMapping("/user/accountTbl")
public class AccountTblController extends BaseController{
    @Autowired
    private IAccountTblService accountTblService;

    @GetMapping("/list")
    public TableDataInfo list(AccountTbl accountTbl){
        startPage();
        List<AccountTbl> list = accountTblService.selectAccountTblList(accountTbl);
        return getDataTable(list);
    }

    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") String id){
        return AjaxResult.success(accountTblService.selectAccountTblById(id));
    }

    @Log(title = "", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody AccountTbl accountTbl){
        return toAjax(accountTblService.insertAccountTbl(accountTbl));
    }

    @Log(title = "", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody AccountTbl accountTbl){
        return toAjax(accountTblService.updateAccountTbl(accountTbl));
    }

    @Log(title = "", businessType = BusinessType.DELETE)
    @DeleteMapping
    public AjaxResult remove(@PathVariable String[] ids){
        return toAjax(accountTblService.deleteAccountTblByIds(ids));
    }
}