package com.nihao.xiagao.study;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class StudyTest extends ArrayList<String>{

    public<T> List<T> getList(){
        return new ArrayList<T>();
    }

    public boolean add(Integer s) {
        return true;
    }

    public void test(List<? extends String> list){

    }

    public static void main(String[] args) {
//        String[] strs = {"1", "2", "3", "4"};
//        List list = Arrays.asList(strs);
//        list.set(0, "5");
//        System.out.println(strs[0]);

//        StudyTest studyTest = new StudyTest();
//        List<String> StringList = studyTest.getList();
//        List list = StringList;
//        list.add(1);
//        System.out.println(list.get(0));

//        File file = new File("C:\\Users\\cstdiohao\\Downloads");
//        String[] strs = file.list(new FilenameFilter() {
//            public boolean accept(File dir, String name) {
//                return name.endsWith(".zip");
//            }
//        });
//        for(String str : strs){
//            System.out.println(str);
//        }

        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(3);
        scheduledExecutorService.scheduleAtFixedRate(new MyRunnable(), 1000, 1000, TimeUnit.MILLISECONDS);
        while(true){
            System.out.println(MyRunnable.num.get());
            try{
                Thread.sleep(477);
            }catch(InterruptedException e){
                e.printStackTrace();
            }

        }
    }

}
