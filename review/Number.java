package com.oop.review;

import java.util.*;

public class Number extends Cmp {
    int val;

    public Number() {
    }

    public Number(int val) {
        this.val = val;
    }

    @Override
    public boolean cmp() {
        return this.val >= 52;
    }

    public static void main(String[] args) {
        Cmp n1 = new Number(55);
        n1.say();
        System.out.println(n1.cmp());
    }
}
