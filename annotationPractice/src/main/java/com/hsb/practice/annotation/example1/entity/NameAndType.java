package com.hsb.practice.annotation.example1.entity;

public class NameAndType {
    private String name;
    private String type;

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setType(String type) {
        this.type = type;
    }
    public NameAndType(){
        super();
    }
    public NameAndType(String name, String type){
        this.name = name;
        this.type = type;
    }
}
