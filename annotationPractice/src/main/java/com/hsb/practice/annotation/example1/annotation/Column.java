package com.hsb.practice.annotation.example1.annotation;/*
 * Copyright ©2011-2016 hsb
 */
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
public @interface Column {
    String name();
}
