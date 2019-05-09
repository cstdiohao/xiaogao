package com.nihao.classload;

import java.io.File;
import java.lang.reflect.Method;
import java.net.URL;
import java.net.URLClassLoader;

public class ClassLoadMain {

    public static void main(String[] args) throws Exception{
//        TestClass testClass = new TestClass();
        File file = new File("E:\\data\\class");
        URLClassLoader classLoader = new URLClassLoader(new URL[]{file.toURI().toURL()});
        Class cla = classLoader.loadClass("com.nihao.classload.ReflectClass");
        Method method = cla.getMethod("r");
        method.invoke(cla.newInstance());
    }

}
