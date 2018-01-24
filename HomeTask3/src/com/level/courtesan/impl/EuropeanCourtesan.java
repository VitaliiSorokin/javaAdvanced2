package com.level.courtesan.impl;

import com.level.courtesan.AbstractCourtesan;

public class EuropeanCourtesan extends AbstractCourtesan{

    public EuropeanCourtesan(String name, int old, int[] sizes) {
        super(name, old, sizes);
    }

    @Override
    public void say() {
        System.out.println("Das Ist Fantastish!");
    }

    @Override
    public void printDetailed() {
        super.printDetailed();
    }
}
