package com.lidaning.demo;

import com.lidaning.demo.user.AccountTbl;
import com.lidaning.demo.user.IAccountTblService;
import com.lidaning.demo.user.IUserService;
import com.supervise.common.core.domain.AjaxResult;
import io.seata.spring.annotation.GlobalTransactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/trans")
public class TransController {
    @Autowired
    IUserService userService;

    @GlobalTransactional
    @GetMapping("/buy")
    public AjaxResult buy(){
        return userService.buy();
    }

}
