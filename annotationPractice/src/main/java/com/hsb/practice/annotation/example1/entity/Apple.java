package com.hsb.practice.annotation.example1.entity;/*
 * Copyright ©2011-2016 hsb
 */

import com.hsb.practice.annotation.example1.annotation.Column;
import com.hsb.practice.annotation.example1.annotation.Id;
import com.hsb.practice.annotation.example1.annotation.Table;

@Table(name = "apple")
public class Apple {
    @Id(name = "id")
    @Column(name = "id")
    int id;
    @Column(name = "color")
    String color;
    @Column(name = "quality")
    String quality;
}
