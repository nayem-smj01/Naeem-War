package com.geek.battle.factory;

import com.geek.battle.model.EnemyArsenal;

import java.util.List;

public class EnemyArsenalFactory {
    public static EnemyArsenal getEnemyArsenal(List<String> armoury){

        int horses = extractWeaponCount(armoury.get(1),1);
        int elephants = extractWeaponCount(armoury.get(2),1);
        int armedTanks = extractWeaponCount(armoury.get(3),2);
        int slingGuns =  extractWeaponCount(armoury.get(4),2);

        return new EnemyArsenal(horses,elephants,armedTanks,slingGuns);
    }

    public static int extractWeaponCount(String weapon,int weaponChars){
        return Integer.parseInt(weapon
                .substring(0,weapon.length()-weaponChars));
    }
}
