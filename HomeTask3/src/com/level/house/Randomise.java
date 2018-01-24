package com.level.house;

import java.util.Random;

public class Randomise {

    public static String getRandomName() {
        String[] Beginning = {"Kr", "Ca", "Ra", "Mrok", "Cru",
                "Ray", "Bre", "Zed", "Drak", "Mor", "Jag", "Mer", "Jar", "Mjol",
                "Zork", "Mad", "Cry", "Zur", "Creo", "Azak", "Azur", "Rei", "Cro",
                "Mar", "Luk"};
        String[] Middle = {"air", "ir", "mi", "sor", "mee", "clo",
                "red", "cra", "ark", "arc", "miri", "lori", "cres", "mur", "zer",
                "marac", "zoir", "slamar", "salmar", "urak"};
        String[] End = {"d", "ed", "ark", "arc", "es", "er", "der",
                "tron", "med", "ure", "zur", "cred", "mur"};

        Random rand = new Random();


        return Beginning[rand.nextInt(Beginning.length)] +
                Middle[rand.nextInt(Middle.length)] +
                End[rand.nextInt(End.length)];
    }

    public static int getRandomAge() {
        Random random = new Random();
        return random.nextInt(82) + 18;
    }

    public static int[] getRandomParams() {
        Random random = new Random();
        return new int[]{random.nextInt(60) + 60, random.nextInt(40) + 40, random.nextInt(60) + 60};

    }
}
