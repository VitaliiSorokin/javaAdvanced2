package com.level.house;

import com.level.courtesan.Courtesan;

import java.util.ArrayList;

public class House <T> {
    private String houseName;
    private HouseLevel houseLevel;
//    private CourtesanArrayList courtesans = new CourtesanArrayList();
    private ArrayList<T> courtesans = new ArrayList<>();

    public House(String houseName, HouseLevel houseLevel) {
        this.houseName = houseName;
        this.houseLevel = houseLevel;
    }

    public House(String houseName, HouseLevel houseLevel, Courtesan[] courtesansArray) {
        this(houseName, houseLevel);
        this.courtesans.add((T) courtesansArray);
    }

    public String getHouseName() {
        return houseName;
    }

    public HouseLevel getHouseLevel() {
        return houseLevel;
    }

    public ArrayList<T> getCourtesans() {
        return courtesans;
    }

    public void registration(Courtesan courtesan) {
        courtesans.add((T) courtesan);
    }

    public void registration(Courtesan[] freshCourtesans) {
        courtesans.add((T) freshCourtesans);
    }

    public void printAll() {
        int i = 0;
//        for (Courtesan courtesan : courtesans.getArray()) {
        for (Courtesan courtesan : courtesans.getArray()) {
            System.out.print(++i + " : ");
            System.out.println(courtesan.getName());
        }
    }

    public void getCourtesanInfo(int index) {
        courtesans.get(index - 1).printDetailed();
    }

    public String getCourtesanNameByIndex(int index) {
        return courtesans.get(index - 1).getName();
    }

}
