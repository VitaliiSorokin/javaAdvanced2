package myarraylist;

import myarraylist.MyArrayList;

public class Demo {
    public static void main(String[] args) {
        MyArrayList<String> list = new MyArrayList<>();

        list.add("one");
        list.add("two");
        list.add("three");
        list.add("four", 1);
        System.out.println(list.get(1));
        System.out.println(list.size());
        list.remove(1);
        System.out.println(list.size());
        System.out.println(list.get(1));




    }
}
