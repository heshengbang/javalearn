package com.hsb.java.util;
        /*
         * Copyright ©2011-2017 hsb
         */

import org.junit.Test;

import java.io.File;
import java.io.FileFilter;
import java.io.IOException;
import java.lang.reflect.Method;
import java.net.URL;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

/**
 * 功能描述: 本文件演示如下功能
 * 输入包名，获取该包下所有的可访问URL
 *
 * 面向的实际需求：统计一个使用SpringMVC工程中所有的URL
 *
 * @author heshengbang
 * @version 1.0
 * @time 2018/3/1 15:31
 * ************************************************
 * @since
 */

public class FindUrlFromPackage {
    @Test
    public void testGetAllClassFromPackage() {
        List<Class> classList = new ArrayList<Class>();
        String pack = "com.hsb.java.util";
        String packageDirName = pack.replace('.', '/');
        Enumeration<URL> dirs;
        try {
            //通过包路径获得包下的所有文件路径
            dirs = Thread.currentThread().getContextClassLoader().getResources(packageDirName);
            while (dirs.hasMoreElements()) {
                URL url = dirs.nextElement();
                String protocol = url.getProtocol();
                //根据url的协议判断，如果是文件协议就去拿这路径下的类
                if ("file".equals(protocol)) {
                    System.out.println("file类型的扫描");
                    String filePath = URLDecoder.decode(url.getFile(), "UTF-8");
                    findClassInPackageByFile(pack, filePath, true, classList);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        //获得了包下的所有类文件，并根据实际要去处理
        for (Class cla : classList) {
            if (cla.getName() != null && cla.getName().endsWith("Controller")) {
                accordingClassGetURL(cla);
            }
        }
    }

    /**
     * 获取类中通过RequestMapping定义的URL
     * @param cla 类
     */
    private void accordingClassGetURL(Class cla) {
        RequestMapping classRequestMapping = (RequestMapping) cla.getAnnotation(RequestMapping.class);
        if (classRequestMapping != null) {
            String classPath = classRequestMapping.value()[0];
            //System.out.println(Arrays.toString(classRequestMapping.value()));
            Method[] methods = cla.getMethods();
            for (Method method: methods) {
                if (method != null) {
                    RequestMapping methodRequestMapping = method.getAnnotation(RequestMapping.class);
                    if (methodRequestMapping != null) {
                        String methodPath = methodRequestMapping.value()[0];
                        if (methodPath != null && !"".equals(methodPath)) {
                            System.out.println(classPath + "/" + methodPath);
                        }
                    }
                }
            }
        }
    }

    /**
     * 在文件中找到，并加入到集合中
     * @param packageName 包名
     * @param filePath 文件路径
     * @param recursive 是否递归寻找
     * @param clazzs 储存的类
     */
    private void findClassInPackageByFile(String packageName, String filePath, final boolean recursive, List<Class> clazzs) {
        File dir = new File(filePath);
        if (!dir.exists() || !dir.isDirectory()) {
            return;
        }
        // 在给定的目录下找到所有的文件，并且进行条件过滤，只要文件夹或者.class文件
        File[] dirFiles = dir.listFiles(new FileFilter() {
            @Override
            public boolean accept(File file) {
                // 接受dir目录
                boolean acceptDir = recursive && file.isDirectory();
                // 接受class文件
                boolean acceptClass = file.getName().endsWith("class");
                return acceptDir || acceptClass;
            }
        });

        if (dirFiles != null) {
            for (File file : dirFiles) {
                //判断文件是否为文件夹，如果是文件夹则继续递归调用寻找其下一层的类文件
                if (file.isDirectory()) {
                    findClassInPackageByFile(packageName + "." + file.getName(), file.getAbsolutePath(), recursive, clazzs);
                } else {
                    //如果不是文件夹则将路径文件夹下的文件名后的.class给去掉，获得类名
                    String className = file.getName().substring(0, file.getName().length() - 6);
                    try {
                        //将类文件拼接到报名下，这样就可以在后面直接使用ClassLoader加载
                        clazzs.add(Thread.currentThread().getContextClassLoader().loadClass(packageName + "." + className));
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}
