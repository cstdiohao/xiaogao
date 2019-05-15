package com.nihao.xiagao.jdk8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class lambda {

    public static void main(String[] args) {
//        int[] a = new int[]{1,2,3,4,5,6,7};
        List<String> strings = Arrays.asList("a", "bbb", "cccc");
//        List<Integer> list = strings.stream()
//                .filter(x -> {
//                    System.out.println(x);
//                    return true;
//                })
//                .map(x -> {
//                    System.out.println(123);
//                    return x.length();
//                })
//                .collect(Collectors.toList());
//
//        String str = strings.stream().max(Comparator.comparing(x -> x.length())).get();
//        System.out.println(str);
//
//        String strSum = strings.stream().reduce("", (x, y) -> x + y);
//        System.out.println("sum " + strSum);
//        strSum = strings.stream().reduce((x,y) -> x + y).get();
//
//        strings.forEach(x -> {
//            System.out.println(x);
//        });
//
//        List<String> strs = Stream.of("a", "b", "c").collect(Collectors.toList());
//
        List<String> list1 = strings.stream().collect(Collector.of(ArrayList::new, List::add, (left, right)->{left.addAll(right); return left;}, Collector.Characteristics.IDENTITY_FINISH));

        double avgLen = strings.stream().collect(Collector.of(() -> new int[2],
                (aa, t) -> {aa[0] += t.length(); aa[1]++;},
                (left, right) -> {left[0] +=right[0]; left[1] += right[1]; return left;},
                aa -> aa[1] == 0 ? 0.0 : (double) aa[0]/aa[1]));
        System.out.println(avgLen);

        String res = strings.stream().collect(Collectors.joining());
        Map<Integer,Long> map = strings.stream().collect(Collectors.groupingBy(strstr -> strstr.length(), Collectors.counting()));
        System.out.println(res);

    }

}
