package com.kgc.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
public class Hotevents {
    private Integer id;
    private String keyWord;
    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "GTM+8")
    private Date createDate;
    private String hoContent;
    private Integer searchSum;
    private List<Comments> list=new ArrayList<>();
}
