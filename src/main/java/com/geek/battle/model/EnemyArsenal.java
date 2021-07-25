package com.geek.battle.model;

public class EnemyArsenal {
    int horses;
    int elephants;
    int armouredTanks;
    int slingGuns;

    public EnemyArsenal(int horses, int elephants, int armouredTanks, int slingGuns) {
        this.horses = horses;
        this.elephants = elephants;
        this.armouredTanks = armouredTanks;
        this.slingGuns = slingGuns;
    }

    public int getHorses() {
        return horses;
    }

    public void setHorses(int horses) {
        this.horses = horses;
    }

    public int getElephants() {
        return elephants;
    }

    public void setElephants(int elephants) {
        this.elephants = elephants;
    }

    public int getArmouredTanks() {
        return armouredTanks;
    }

    public void setArmouredTanks(int armouredTanks) {
        this.armouredTanks = armouredTanks;
    }

    public int getSlingGuns() {
        return slingGuns;
    }

    public void setSlingGuns(int slingGuns) {
        this.slingGuns = slingGuns;
    }

    @Override
    public String toString() {
        return "EnemyArsenal{" +
                "horses=" + horses +
                ", elephants=" + elephants +
                ", armouredTanks=" + armouredTanks +
                ", slingGuns=" + slingGuns +
                '}';
    }
}
