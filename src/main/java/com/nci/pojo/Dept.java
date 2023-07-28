package com.nci.pojo;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;


@Data
public class Dept {
    private Integer id;
    private String  name;
    private LocalDateTime createTime;
    private LocalDateTime updateTime;
}
