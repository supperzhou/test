package com.kgc.controller;

import com.alibaba.fastjson.JSON;
import com.kgc.pojo.Hotevents;
import com.kgc.service.impl.HoteventsServiceImpl;
import com.kgc.util.PageUtil;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

@Controller
public class HoteventsController {
    @Resource
    HoteventsServiceImpl hoteventsService;
    @RequestMapping("/show")
    public String getShow(@RequestParam(value = "pageIndex",defaultValue = "1",required = false)Integer pageIndex,
                          Model model,@RequestParam(value = "keyWord",required = false)String keyWord){
        PageUtil<Hotevents> page = hoteventsService.getForPage(pageIndex, 3, keyWord);
        model.addAttribute("page",page);
        return "index";
    }
    @PostMapping(value = "/getshow",produces = {"application/json;charset=utf-8"})
    @ResponseBody
    public PageUtil<Hotevents> getShow2(@RequestParam(value = "pageIndex",defaultValue = "1",required = false)Integer pageIndex,
            @RequestParam(value = "keyWord",required = false)String keyWord){
        PageUtil<Hotevents> page = hoteventsService.getForPage(pageIndex, 2, keyWord);
        return page;
    }
}
