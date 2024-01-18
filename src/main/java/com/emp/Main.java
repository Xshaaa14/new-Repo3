package com.emp;

import java.util.function.Predicate;

public class Main {
    public static void main(String[] args) {
        Predicate<Integer> condition = x->x>0;
        boolean val = condition.test(100);
        System.out.println(val);
    }
}
