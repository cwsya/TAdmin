package org.cwsya.tadmin.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author cws
 */
@RestController
public class TestController {

    @PostMapping("/a")
    public String test1(){
        return "a";
    }
    @PostMapping("/b")
    public String test2(){
        return "a";
    }
    @PostMapping("/c")
    public String test3(){
        return "a";
    }
    @PostMapping("/d")
    public String test4(){
        return "a";
    }
    @PostMapping("/e")
    public String test5(){
        return "a";
    }
}
