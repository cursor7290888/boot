package com.baizhi.boot.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Album implements Serializable {
    private Integer id;

    private String title;

    private String description;

    private String coverPic;

    private String author;

    private Date pubUpdate;

    private Integer score;

    private Integer count;

    private String broadcaster;


}