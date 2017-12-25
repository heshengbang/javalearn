package com.hsb.java.oom.java_heap_space;/*
 * Copyright ©2011-2016 hsb
 */

import java.util.*;

public class KeylessEntry {

    static class Key {
        Integer id;

        Key(Integer id) {
            this.id = id;
        }

        @Override
        public int hashCode() {
            return id.hashCode();
        }

        @Override
        public boolean equals(Object o) {
            boolean response = false;
            if (o instanceof Key) {
                response = (((Key)o).id).equals(this.id);
            }
            return response;
        }
    }

    public static void main(String[] args) {
        Map m = new HashMap();
        //jdk8 when size become 9480000, java heap space oom will occured.
        while (true){
            for (int i = 0; i < 10000; i++){
                if (!m.containsKey(new Key(i))){
                    m.put(new Key(i), "Number:" + i);
                }
            }
            System.out.println("m.size()=" + m.size());
        }
    }
}
