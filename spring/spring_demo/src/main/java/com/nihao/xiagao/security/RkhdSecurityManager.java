package com.nihao.xiagao.security;

import javax.management.MBeanTrustPermission;
import java.security.Permission;

/**
 * Created by yanghaitian on 2016/4/12.
 */
public class RkhdSecurityManager extends SecurityManager{
//    private Permission permission;
    @Override
    public void checkPermission(Permission perm) {
        if(perm.getName() != null && perm.getName().indexOf("exitVM") == 0){
            throw new RuntimeException("cannot exitVM");
		}
//		permission = perm;
		if(perm instanceof java.net.SocketPermission || perm instanceof MBeanTrustPermission){
            return ;
        }
        try{
            super.checkPermission(perm);
        }catch(Exception e){
            StackTraceElement[] stackTraceElements = Thread.currentThread().getStackTrace();
            isOther(e,stackTraceElements);
        }
    }

    @Override
    public void checkExec(String cmd){
        StackTraceElement[] stackTraceElements = Thread.currentThread().getStackTrace();
        isOther(new RuntimeException("other code cannot use exec cmd"),stackTraceElements);
    }

    @Override
    public void checkMemberAccess(Class<?> clazz, int which) {
        if(clazz.getName().equals("java.util.TimerThread")){
            StackTraceElement[] stackTraceElements = Thread.currentThread().getStackTrace();
            isOther(new RuntimeException("other code cannot use TimerThread"),stackTraceElements);
        }
    }

    @Override
    public void checkAccess(Thread t) {
        StackTraceElement[] stackTraceElements = Thread.currentThread().getStackTrace();
        isOther(new RuntimeException("other code cannot use thread"),stackTraceElements);
    }

    @Override
    public void checkAccess(ThreadGroup g) {
        StackTraceElement[] stackTraceElements = Thread.currentThread().getStackTrace();
        isOther(new RuntimeException("other code cannot use threadGroup"),stackTraceElements);
    }

    private void isOther(Exception e,StackTraceElement[] stackTraceElements){
        boolean isOthers = false;
        boolean isOtherError = true;
        for(int i = stackTraceElements.length-1 ;i >= 0 ;i--){
            StackTraceElement stackTraceElement = stackTraceElements[i];
            if(stackTraceElement.getClassName().indexOf("other.") == 0){
                isOthers = true;
            }
            if(isOthers){
                if(stackTraceElement.getClassName().indexOf("com.rkhd") == 0 && !stackTraceElement.getClassName().equals("com.rkhd.platform.scriptrt.util.securitymanager.RkhdSecurityManager")){
                    isOtherError = false;
                    break;
                }
                if(stackTraceElement.getClassName().indexOf("javax.xml.ws") == 0 ||
                        stackTraceElement.getClassName().indexOf("java.net.Authenticator") == 0 ||
                        stackTraceElement.getClassName().indexOf("java.net.URL") == 0 ||
//                        stackTraceElement.getClassName().indexOf("java.net.InetAddress") == 0 ||
                        stackTraceElement.getClassName().indexOf("com.sun.xml.internal.ws") == 0){
                    isOtherError = false;
                    break;
                }
            }
        }
        if(isOthers && isOtherError){
            throw new RuntimeException(e);
        }
    }
}
