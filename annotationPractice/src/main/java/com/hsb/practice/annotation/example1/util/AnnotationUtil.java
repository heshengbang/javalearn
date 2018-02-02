package com.hsb.practice.annotation.example1.util;/*
 * Copyright ©2011-2016 hsb
 */

import com.hsb.practice.annotation.example1.annotation.Column;
import com.hsb.practice.annotation.example1.annotation.Id;
import com.hsb.practice.annotation.example1.annotation.Table;
import com.hsb.practice.annotation.example1.entity.NameAndType;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public class AnnotationUtil {
    private static String getTableName(Class<?> bean) {
        String name = null;
        if (bean.isAnnotationPresent(Table.class)) {
            Table table = bean.getAnnotation(Table.class);
            name = table.name();
        }
        return name;
    }

    private static String getPrimaryKey(Class<?> bean) throws Exception {
        String name = null;
        Field[] fields = bean.getDeclaredFields();
        if (fields != null) {
            for (Field field : fields) {
                if (field.isAnnotationPresent(Id.class)) {
                    Id id = field.getAnnotation(Id.class);
                    if(name != null) {
                        throw new Exception("只能用一个@Id来注释主键");
                    }else {
                        name = id.name();
                    }
                }
            }
            if (name == null) {
                throw new Exception("需要用@Id注释出表的主键");
            }
        }
        return  name;
    }

    private static List<NameAndType> getColumns(Class<?> bean) {
        List<NameAndType> columns = new ArrayList<NameAndType>();
        Field[] fields = bean.getDeclaredFields();
        if(fields != null) {
            for (Field field : fields) {
                if(field.isAnnotationPresent(Column.class)) {
                    Column column = field.getAnnotation(Column.class);
                    String name = column.name();
                    String type = null;
                    if(int.class.isAssignableFrom(field.getType())) {
                        type = "integer";
                    } else if (String.class.isAssignableFrom(field.getType())) {
                        type = "text";
                    } else {
                        throw new RuntimeException("Unsupported type="+field.getType().getSimpleName());
                    }
                    columns.add(new NameAndType(name, type));
                }
            }
        }
        return  columns;
    }

    public static String createTable(Class<?> bean) throws Exception {
        String tableName = getTableName(bean);
        List<NameAndType> columns = getColumns(bean);
        String primaryKey = getPrimaryKey(bean);
        if (tableName != null && !tableName.equals("") && !columns.isEmpty()) {
            StringBuilder createTableSql = new StringBuilder("create table ");
            createTableSql.append(tableName);
            createTableSql.append("(");
            for (NameAndType column : columns) {
                String name = column.getName();
                createTableSql.append(name);
                createTableSql.append(" ");
                createTableSql.append(column.getType());
                if (primaryKey.equalsIgnoreCase(name)){
                    createTableSql.append(" NOT NULL AUTO_INCREMENT");
                }
                createTableSql.append(",");
            }
            createTableSql.append("PRIMARY KEY (").append(primaryKey).append(") );");
            return createTableSql.toString();
        }
        return null;
    }
}





















