package com.level.courtesan.impl;

import com.level.courtesan.AbstractCourtesan;

public class AsianCourtesan extends AbstractCourtesan {
    public AsianCourtesan(String name, int old, int[] sizes) {
        super(name, old, sizes);
    }

    @Override
    public void say() {
        System.out.println("Nya Nya");
    }

    @Override
    public void printDetailed() {
        super.printDetailed();
    }
}
