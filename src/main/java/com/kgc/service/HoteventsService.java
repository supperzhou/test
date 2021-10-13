package com.kgc.service;

import com.kgc.pojo.Hotevents;
import com.kgc.util.PageUtil;

public interface HoteventsService {
    PageUtil<Hotevents> getForPage(Integer pageIndex,Integer pageSize,String keyWord);
    Hotevents getById(Integer id);
}
