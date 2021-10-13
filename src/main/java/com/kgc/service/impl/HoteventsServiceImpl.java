package com.kgc.service.impl;

import com.kgc.mapper.HoteventsMapper;
import com.kgc.pojo.Hotevents;
import com.kgc.service.HoteventsService;
import com.kgc.util.PageUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
@Service
public class HoteventsServiceImpl implements HoteventsService
{
    @Resource
    HoteventsMapper hoteventsMapper;
    @Override
    public PageUtil<Hotevents> getForPage(Integer pageIndex, Integer pageSize, String keyWord) {
        PageUtil<Hotevents> pageUtil=new PageUtil<>();
        pageUtil.setPageSize(pageSize);
        pageUtil.setTotalCount(hoteventsMapper.getCount(keyWord));
        pageUtil.setList(hoteventsMapper.getAll((pageIndex-1)*pageSize,pageSize,keyWord));
        pageUtil.setPageIndex(pageIndex);
        return pageUtil;

    }

    @Override
    public Hotevents getById(Integer id) {
        return hoteventsMapper.getById(id);
    }
}
