package com.geek.battle.service;

import com.geek.battle.model.BattleResult;
import com.geek.battle.model.EnemyArsenal;
import com.geek.battle.model.Weapon;

import java.util.List;

public interface WarService {
    String battle(List<String> armory);

    String evaluateBattleOutCome(EnemyArsenal arsenal);

    /**
     * Weapon formula <br> <b>
     *  2 * lowerOrderWeapon =  current = 1/2 higherOrderWeapon </b> <br>
     * @param current
     * @param higherOrderWeapon
     * @param lowerOrderWeapon
     * @param remainingEnemyArsenal
     * @return
     */
    BattleResult addReserves(Weapon current, Weapon higherOrderWeapon, Weapon lowerOrderWeapon,
                       BattleResult battleResult,int remainingEnemyArsenal, String weaponAbbreviation);
}
