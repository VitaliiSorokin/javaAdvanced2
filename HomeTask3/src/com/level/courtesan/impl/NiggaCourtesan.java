package com.level.courtesan.impl;

import com.level.courtesan.AbstractCourtesan;

public class NiggaCourtesan extends AbstractCourtesan {

    public NiggaCourtesan(String name, int old, int[] sizes) {
        super(name, old, sizes);
    }

    @Override
    public void say() {
        System.out.println("Nigga nigga nigga!");
    }

    @Override
    public void printDetailed() {
        super.printDetailed();
    }
}
