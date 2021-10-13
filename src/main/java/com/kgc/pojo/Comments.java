package com.kgc.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

@Data
public class Comments {
    private Integer id;
    private Integer hoteId;
    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "GTM+8")
    private Date commentDate;
    private String content;
}
