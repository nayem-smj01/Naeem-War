package com.geek.battle.factory;

import com.geek.battle.ArmouryConstants;
import com.geek.battle.model.Weapon;

public class WeaponFactory {
    public static Weapon createWeapon(String weaponName){
        Weapon weapon = null;
        switch (weaponName){
            case ArmouryConstants.HORSE:{
                weapon = new Weapon("Horses",100,"Elephants",null);
                weapon.setAbbreviatedName(weaponName);
                return weapon;
            }
            case ArmouryConstants.ELEPHANTS:{
                weapon = new Weapon("Elephants",50,"Armoured Tanks","Horses");
                weapon.setAbbreviatedName(weaponName);
                return weapon;
            }
            case ArmouryConstants.ARMOURED_TANKS:{
                weapon = new Weapon("Armoured Tanks",10,"Sling Guns","Elephants");
                weapon.setAbbreviatedName(weaponName);
                return weapon;
            }
            case ArmouryConstants.SLING_GUNS:{
                weapon = new Weapon("Sling Guns",5,null,"Armoured Tanks");
                weapon.setAbbreviatedName(weaponName);
                return weapon;
            }
            default:
                return null;
        }

    }
}
