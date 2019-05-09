package com.nihao.xiagao.security;

import java.net.InetAddress;

public class Main {

    public static void main(String[] args) throws Exception{
        RkhdSecurityManager rkhdSecurityManager = new RkhdSecurityManager();
        System.setSecurityManager(rkhdSecurityManager);
        Long begin = System.currentTimeMillis();
        System.out.println(InetAddress.getAllByName("xiaoshouyi.api.qcloud.com")[0].getHostAddress());
        Long end = System.currentTimeMillis();
        System.out.println(end - begin);
    }

}
