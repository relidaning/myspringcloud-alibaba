package com.lidaning.user;

import com.lidaning.user.user.IUserService;
import com.supervise.common.core.domain.AjaxResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/trans")
public class TransController {
    @Autowired
    IUserService userService;

    @GetMapping("/buy")
    public AjaxResult buy(){
        return userService.buy();
    }

}
