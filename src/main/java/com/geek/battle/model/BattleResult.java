package com.geek.battle.model;

import com.geek.battle.ArmouryConstants;

public class BattleResult {
    String battleOutcome;

    String horse;
    int horseCount;

    String elephant;
    int elephantCount;

    String armedTanks;
    int armedTanksCount;

    String slingShots;
    int slingShotCount;

    public BattleResult() {
        horseCount = elephantCount = armedTanksCount = slingShotCount = 0;
        horse = ArmouryConstants.HORSE;
        elephant = ArmouryConstants.ELEPHANTS;
        armedTanks = ArmouryConstants.ARMOURED_TANKS;
        slingShots = ArmouryConstants.SLING_GUNS;
    }

    @Override
    public String toString() {
        return battleOutcome + " "
                + horseCount + horse + " "
                + elephantCount + elephant + " "
                + armedTanksCount + armedTanks + " "
                + slingShotCount + slingShots;
    }


    public String getBattleOutcome() {
        return battleOutcome;
    }

    public void setBattleOutcome(String battleOutcome) {
        this.battleOutcome = battleOutcome;
    }

    public String getHorse() {
        return horse;
    }

    public void setHorse(String horse) {
        this.horse = horse;
    }

    public int getHorseCount() {
        return horseCount;
    }

    public void setHorseCount(int horseCount) {
        this.horseCount = horseCount;
    }

    public String getElephant() {
        return elephant;
    }

    public void setElephant(String elephant) {
        this.elephant = elephant;
    }

    public int getElephantCount() {
        return elephantCount;
    }

    public void setElephantCount(int elephantCount) {
        this.elephantCount = elephantCount;
    }

    public String getArmedTanks() {
        return armedTanks;
    }

    public void setArmedTanks(String armedTanks) {
        this.armedTanks = armedTanks;
    }

    public int getArmedTanksCount() {
        return armedTanksCount;
    }

    public void setArmedTanksCount(int armedTanksCount) {
        this.armedTanksCount = armedTanksCount;
    }

    public String getSlingShots() {
        return slingShots;
    }

    public void setSlingShots(String slingShots) {
        this.slingShots = slingShots;
    }

    public int getSlingShotCount() {
        return slingShotCount;
    }

    public void setSlingShotCount(int slingShotCount) {
        this.slingShotCount = slingShotCount;
    }


}
