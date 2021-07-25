package com.geek.battle.model;

public class Weapon {
    String name;
    int count;
    String higherSubstitutionWeapon;
    String lowerSubstitutionWeapon;
    String abbreviatedName;

    public String getAbbreviatedName() {
        return abbreviatedName;
    }

    public void setAbbreviatedName(String abbreviatedName) {
        this.abbreviatedName = abbreviatedName;
    }



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public String getHigherSubstitutionWeapon() {
        return higherSubstitutionWeapon;
    }

    public void setHigherSubstitutionWeapon(String higherSubstitutionWeapon) {
        this.higherSubstitutionWeapon = higherSubstitutionWeapon;
    }

    public String getLowerSubstitutionWeapon() {
        return lowerSubstitutionWeapon;
    }

    public void setLowerSubstitutionWeapon(String lowerSubstitutionWeapon) {
        this.lowerSubstitutionWeapon = lowerSubstitutionWeapon;
    }

    public Weapon() {
    }

    public Weapon(String name, int count, String higherSubstitutionWeapon, String lowerSubstitutionWeapon) {
        this.name = name;
        this.count = count;
        this.higherSubstitutionWeapon = higherSubstitutionWeapon;
        this.lowerSubstitutionWeapon = lowerSubstitutionWeapon;
    }


}
