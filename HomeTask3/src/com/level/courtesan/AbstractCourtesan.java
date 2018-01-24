package com.level.courtesan;

import java.util.Arrays;

public abstract class AbstractCourtesan implements Courtesan {
    private String name;
    private int age;
    private int[] sizes = new int[3];

    public AbstractCourtesan(String name, int age, int[] sizes) {
        this.name = name;
        this.age = age;
        this.sizes = sizes;
    }

    public void printDetailed() {
        System.out.println(name);
        System.out.println(age);
        System.out.println(Arrays.toString(sizes));
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int[] getSizes() {
        return sizes;
    }

    public void setSizes(int[] sizes) {
        this.sizes = sizes;
    }
}
