package org.cwsya.tadmin.controller;

import cn.dev33.satoken.annotation.SaCheckLogin;
import cn.dev33.satoken.annotation.SaCheckPermission;
import cn.dev33.satoken.annotation.SaCheckRole;
import cn.dev33.satoken.annotation.SaCheckSafe;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author cws
 */
@RestController
public class TestController {

    @SaCheckLogin
    @PostMapping("/a")
    public String test1(){
        return "a";
    }
    @SaCheckRole("super-admin")
    @PostMapping("/b")
    public String test2(){
        return "a";
    }
    @SaCheckRole("admin")
    @PostMapping("/c")
    public String test3(){
        return "a";
    }
    @SaCheckPermission("d")
    @PostMapping("/d")
    public String test4(){
        return "a";
    }
    @SaCheckSafe()
    @PostMapping("/e")
    public String test5(){
        return "a";
    }
}
