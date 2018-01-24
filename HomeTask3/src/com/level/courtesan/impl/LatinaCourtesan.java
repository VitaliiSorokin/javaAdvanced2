package com.level.courtesan.impl;

import com.level.courtesan.AbstractCourtesan;

public class LatinaCourtesan extends AbstractCourtesan {

    public LatinaCourtesan(String name, int old, int[] sizes) {
        super(name, old, sizes);
    }

    @Override
    public void say() {
        System.out.println("Salsa!");
    }

    @Override
    public void printDetailed() {
        super.printDetailed();
    }
}
