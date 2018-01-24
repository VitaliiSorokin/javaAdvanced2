package com.level.house;

import com.level.courtesan.Courtesan;

public class CourtesanArrayList {
    private int lastCurrentIndex = 0;

    private Courtesan[] courtesans = new Courtesan[3];

    public void add(Courtesan courtesan) {
        if (lastCurrentIndex == this.courtesans.length - 1) {
            addSize();
        }
        this.courtesans[lastCurrentIndex++] = courtesan;
    }

    public void add(Courtesan[] courtesans) {
        while (lastCurrentIndex + courtesans.length > this.courtesans.length - 1) {
            addSize();
        }
        System.arraycopy(courtesans, 0, this.courtesans, lastCurrentIndex, courtesans.length);
        lastCurrentIndex += courtesans.length;
    }

    public Courtesan get(int index) {
        return courtesans[index];
    }

    public Courtesan[] getArray() {
        Courtesan[] courtesans = new Courtesan[lastCurrentIndex];
        System.arraycopy(this.courtesans, 0, courtesans, 0, lastCurrentIndex);
        return courtesans;
    }

    public int getSize() {
        return lastCurrentIndex;
    }

    private void addSize() {
        Courtesan[] courtesans = new Courtesan[getNewArraySize()];
        System.arraycopy(this.courtesans, 0, courtesans, 0, this.courtesans.length);
        this.courtesans = courtesans;
    }

    private int getNewArraySize() {
        return this.courtesans.length + this.courtesans.length / 2 + 1;
    }

}
