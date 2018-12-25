package com.leo.spring.strategy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class MyListTest {
    /**
     * 策略模式的结果是固定的，但是过程是不同的
     * 例如Collections工具类的sort方法，sort的结果是固定的，但是每种实现类比较的过程是不同的
     * @param args
     */
    public static void main(String[] args) {
       // new MyList().sort(new NumberComparator());
        //策略模式
        List<Long> numbers = new ArrayList<>();
        Collections.sort(numbers, new Comparator<Long>() {
            //返回值是固定的
			//0 、-1 、1
			//0 、 >0 、<0
            @Override
            public int compare(Long o1, Long o2) {
                //中间逻辑是不一样的
                return 0;
            }
        });
    }
}
