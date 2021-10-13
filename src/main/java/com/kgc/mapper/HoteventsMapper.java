package com.kgc.mapper;

import com.kgc.pojo.Hotevents;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface HoteventsMapper {
    List<Hotevents> getAll(@Param("pageIndex")Integer pageIndex,@Param("pageSize")Integer pageSize,@Param("keyWord")String keyWord);
    Integer getCount(@Param("keyWord")String keyWord);
    Hotevents getById(Integer id);
}
