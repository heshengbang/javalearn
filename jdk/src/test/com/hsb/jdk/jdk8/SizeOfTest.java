package com.hsb.jdk.jdk8;

import org.ehcache.sizeof.SizeOf;

/**
 * created by heshengbang
 * Blog: https://www.heshengbang.tech
 * Twitter: https://twitter.com/heshengbang
 * Github: https://github.com/heshengbang
 * Time: 2018/10/31 15:19
 */

public class SizeOfTest {
    public static void main(String[] args) {
        charTest();
    }

    public static void charTest() {
        char var1 = 0;
        char var2 = 65535;
        char var3 = 128;
        SizeOf sizeOf = SizeOf.newInstance();
        System.out.println("sizeOf=" + sizeOf.sizeOf(var1) + "    deepSizeOf=" + sizeOf.deepSizeOf(var1));
        System.out.println("sizeOf=" + sizeOf.sizeOf(var2) + "    deepSizeOf=" + sizeOf.deepSizeOf(var2));
        System.out.println("sizeOf=" + sizeOf.sizeOf(var3) + "    deepSizeOf=" + sizeOf.deepSizeOf(var3));
    }

    public static void booleanTest() {
        boolean var1 = Boolean.parseBoolean(null);
        boolean var2 = true;
        boolean var3 = false;
        SizeOf sizeOf = SizeOf.newInstance();
        System.out.println("sizeOf=" + sizeOf.sizeOf(var1) + "    deepSizeOf=" + sizeOf.deepSizeOf(var1));
        System.out.println("sizeOf=" + sizeOf.sizeOf(var2) + "    deepSizeOf=" + sizeOf.deepSizeOf(var2));
        System.out.println("sizeOf=" + sizeOf.sizeOf(var3) + "    deepSizeOf=" + sizeOf.deepSizeOf(var3));
    }

    public static void longTest() {
        long var1 = -129;
        long var2 = -128;
        long var3 = 9223372036854775807L;
        SizeOf sizeOf = SizeOf.newInstance();
        System.out.println("sizeOf=" + sizeOf.sizeOf(var1) + "    deepSizeOf=" + sizeOf.deepSizeOf(var1));
        System.out.println("sizeOf=" + sizeOf.sizeOf(var2) + "    deepSizeOf=" + sizeOf.deepSizeOf(var2));
        System.out.println("sizeOf=" + sizeOf.sizeOf(var3) + "    deepSizeOf=" + sizeOf.deepSizeOf(var3));
    }

    public static void doubleTest() {
        double var1 = 0d;
        double var2 = 125d;
        double var3 = -128.0d;
        SizeOf sizeOf = SizeOf.newInstance();
        System.out.println("sizeOf=" + sizeOf.sizeOf(var1) + "    deepSizeOf=" + sizeOf.deepSizeOf(var1));
        System.out.println("sizeOf=" + sizeOf.sizeOf(var2) + "    deepSizeOf=" + sizeOf.deepSizeOf(var2));
        System.out.println("sizeOf=" + sizeOf.sizeOf(var3) + "    deepSizeOf=" + sizeOf.deepSizeOf(var3));
    }

    public static void floatTest() {
        float var1 = 0f;
        float var2 = 125f;
        float var3 = -128.0f;
        SizeOf sizeOf = SizeOf.newInstance();
        System.out.println("sizeOf=" + sizeOf.sizeOf(var1) + "    deepSizeOf=" + sizeOf.deepSizeOf(var1));
        System.out.println("sizeOf=" + sizeOf.sizeOf(var2) + "    deepSizeOf=" + sizeOf.deepSizeOf(var2));
        System.out.println("sizeOf=" + sizeOf.sizeOf(var3) + "    deepSizeOf=" + sizeOf.deepSizeOf(var3));
    }



    public static void intTest() {
        int var1 = 128;
        int var2 = -2147483648;
        int var3 = 2147483647;
        SizeOf sizeOf = SizeOf.newInstance();
        System.out.println("sizeOf=" + sizeOf.sizeOf(var1) + "    deepSizeOf=" + sizeOf.deepSizeOf(var1));
        System.out.println("sizeOf=" + sizeOf.sizeOf(var2) + "    deepSizeOf=" + sizeOf.deepSizeOf(var2));
        System.out.println("sizeOf=" + sizeOf.sizeOf(var3) + "    deepSizeOf=" + sizeOf.deepSizeOf(var3));
    }

    public static void shortTest() {
        short var1 = 127;
        short var2 = 32767;
        short var3 = 32767;
        SizeOf sizeOf = SizeOf.newInstance();
        System.out.println("sizeOf=" + sizeOf.sizeOf(var1) + "    deepSizeOf=" + sizeOf.deepSizeOf(var1));
        System.out.println("sizeOf=" + sizeOf.sizeOf(var2) + "    deepSizeOf=" + sizeOf.deepSizeOf(var2));
        System.out.println("sizeOf=" + sizeOf.sizeOf(var3) + "    deepSizeOf=" + sizeOf.deepSizeOf(var3));
    }

    public static void byteTest() {
        byte var1 = 0;
        byte var2 = 127;
        byte var3 = -128;
        SizeOf sizeOf = SizeOf.newInstance();
        System.out.println("sizeOf=" + sizeOf.sizeOf(var1) + "    deepSizeOf=" + sizeOf.deepSizeOf(var1));
        System.out.println("sizeOf=" + sizeOf.sizeOf(var2) + "    deepSizeOf=" + sizeOf.deepSizeOf(var2));
        System.out.println("sizeOf=" + sizeOf.sizeOf(var3) + "    deepSizeOf=" + sizeOf.deepSizeOf(var3));
    }
}
