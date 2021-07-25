package com.geek.battle.service;

import com.geek.battle.ArmouryConstants;
import com.geek.battle.factory.EnemyArsenalFactory;
import com.geek.battle.factory.WeaponFactory;
import com.geek.battle.model.BattleResult;
import com.geek.battle.model.EnemyArsenal;
import com.geek.battle.model.Weapon;

import java.util.List;

public class WarServiceImpl implements WarService {
    @Override
    public String battle(List<String> armoury) {
        if (armoury.isEmpty() || armoury.size() < 1)
            return null;
        EnemyArsenal arsenal = EnemyArsenalFactory.getEnemyArsenal(armoury);
        return evaluateBattleOutCome(arsenal);

    }

    @Override
    public String evaluateBattleOutCome(EnemyArsenal enemyArsenal) {
        BattleResult battleResult = new BattleResult();
        Weapon horses = WeaponFactory.createWeapon(ArmouryConstants.HORSE);
        Weapon elephants = WeaponFactory.createWeapon(ArmouryConstants.ELEPHANTS);
        Weapon armedTanks = WeaponFactory.createWeapon(ArmouryConstants.ARMOURED_TANKS);
        Weapon slingGuns = WeaponFactory.createWeapon(ArmouryConstants.SLING_GUNS);

        // 2 enemy horses strength = 1 horse strength
        //When our horses are more then enemy-horses
        getOutcome(enemyArsenal.getHorses(), battleResult, horses,
                elephants, null, ArmouryConstants.HORSE);

        getOutcome(enemyArsenal.getElephants(), battleResult,
                elephants, armedTanks, horses, ArmouryConstants.ELEPHANTS);

        getOutcome(enemyArsenal.getArmouredTanks(), battleResult,
                armedTanks, slingGuns, elephants, ArmouryConstants.ARMOURED_TANKS);

        getOutcome(enemyArsenal.getSlingGuns(), battleResult,
                slingGuns,null, armedTanks,  ArmouryConstants.SLING_GUNS);

        //System.out.println("battleResult: "+battleResult);
        finalOutcome(enemyArsenal,battleResult);

        return battleResult.toString();
    }

    private BattleResult getOutcome(int enemyArsenal, BattleResult battleResult, Weapon currentWeapon,
                                    Weapon higherOrderWeapon, Weapon lowerOrderWeapon, String weaponAbbreviation) {
        boolean enemyArsenalNoOdd = !(enemyArsenal % 2 == 0);
        if (enemyArsenal / 2 <= currentWeapon.getCount()) {

            if (ArmouryConstants.HORSE.equals(weaponAbbreviation)) {
                battleResult.setHorseCount(battleResult.getHorseCount() + (enemyArsenal / 2) + (enemyArsenalNoOdd ? 1 : 0));
            }
            if (ArmouryConstants.ELEPHANTS.equals(weaponAbbreviation)) {
                battleResult.setElephantCount(battleResult.getElephantCount() + (enemyArsenal / 2) + (enemyArsenalNoOdd ? 1 : 0));
            }
            if (ArmouryConstants.ARMOURED_TANKS.equals(weaponAbbreviation)) {
                battleResult.setArmedTanksCount(battleResult.getArmedTanksCount() + (enemyArsenal / 2) + (enemyArsenalNoOdd ? 1 : 0));
            }
            if (ArmouryConstants.SLING_GUNS.equals(weaponAbbreviation)) {
                battleResult.setSlingShotCount(battleResult.getSlingShotCount() + (enemyArsenal / 2) + (enemyArsenalNoOdd ? 1 : 0));
            }
            currentWeapon.setCount(
                    currentWeapon.getCount() - (enemyArsenal / 2));
        } else {
            // remainingEnemyArsenal is Difference between [(DOUBLE * EnemyArsenal) - ourArsenal]
            int remainingEnemyArsenal = (enemyArsenal) - currentWeapon.getCount() * 2;
            addReserves(currentWeapon, higherOrderWeapon, lowerOrderWeapon,
                    battleResult, remainingEnemyArsenal, weaponAbbreviation);
        }
        return battleResult;
    }

    @Override
    public BattleResult addReserves(Weapon currentWeapon, Weapon higherOrderWeapon, Weapon lowerOrderWeapon,
                                    BattleResult battleResult, int remainingEnemyArsenal, String weaponAbbreviation) {
        boolean enemyArsenalNoOdd = !(remainingEnemyArsenal % 2 == 0);

        if (validLowerOrderWeapon(lowerOrderWeapon, remainingEnemyArsenal)) {
            int lowerOrderWeaponCount = remainingEnemyArsenal * 2;
            lowerOrderWeapon.setCount(lowerOrderWeapon.getCount() - lowerOrderWeaponCount);

            if (lowerOrderWeapon.getAbbreviatedName().equals(ArmouryConstants.HORSE)) {
                battleResult.setHorseCount(battleResult.getHorseCount() +
                        lowerOrderWeaponCount + (enemyArsenalNoOdd ? 1 : 0));
                battleResult.setElephantCount(currentWeapon.getCount());

            }
            if (lowerOrderWeapon.getAbbreviatedName().equals(ArmouryConstants.ELEPHANTS)) {
                battleResult.setElephantCount(battleResult.getElephantCount() +
                        lowerOrderWeaponCount + (enemyArsenalNoOdd ? 1 : 0));
                battleResult.setArmedTanksCount(currentWeapon.getCount());
            }
            if (lowerOrderWeapon.getAbbreviatedName().equals(ArmouryConstants.ARMOURED_TANKS)) {
                battleResult.setArmedTanksCount(battleResult.getArmedTanksCount() +
                        lowerOrderWeaponCount + (enemyArsenalNoOdd ? 1 : 0));
                battleResult.setSlingShotCount(currentWeapon.getCount());
            }
            currentWeapon.setCount(0);
        }

        else {
            if (validHigherOrderWeapon(higherOrderWeapon, remainingEnemyArsenal)) {
                int higherOrderWeaponsCount = remainingEnemyArsenal / 4;
                if (higherOrderWeapon.getAbbreviatedName().equals(ArmouryConstants.ELEPHANTS)) {
                    battleResult.setElephantCount(battleResult.getElephantCount() + higherOrderWeaponsCount);
                    battleResult.setHorseCount(currentWeapon.getCount());

                }

                if (higherOrderWeapon.getAbbreviatedName().equals(ArmouryConstants.ARMOURED_TANKS)) {
                    battleResult.setArmedTanksCount(battleResult.getArmedTanksCount() + higherOrderWeaponsCount);
                    battleResult.setElephantCount(currentWeapon.getCount());
                }

                if (higherOrderWeapon.getAbbreviatedName().equals(ArmouryConstants.SLING_GUNS)) {
                    battleResult.setSlingShotCount(battleResult.getSlingShotCount() + higherOrderWeaponsCount);
                    battleResult.setArmedTanksCount(currentWeapon.getCount());
                }

                higherOrderWeapon.setCount(higherOrderWeapon.getCount() - higherOrderWeaponsCount);
                currentWeapon.setCount(0);

            }
            else {
                setRemainingArmour(battleResult,weaponAbbreviation,currentWeapon);
            }

        }
        return battleResult;
    }

    private void setRemainingArmour(BattleResult battleResult, String weaponAbbreviation, Weapon currentWeapon) {
        if (ArmouryConstants.HORSE.equals(weaponAbbreviation)) {
            battleResult.setHorseCount(battleResult.getHorseCount() + currentWeapon.getCount() );
        }
        if (ArmouryConstants.ELEPHANTS.equals(weaponAbbreviation)) {
            battleResult.setElephantCount(battleResult.getElephantCount() + currentWeapon.getCount());
        }
        if (ArmouryConstants.ARMOURED_TANKS.equals(weaponAbbreviation)) {
            battleResult.setArmedTanksCount(battleResult.getArmedTanksCount()  + currentWeapon.getCount());
        }
        if (ArmouryConstants.SLING_GUNS.equals(weaponAbbreviation)) {
            battleResult.setSlingShotCount(battleResult.getSlingShotCount() + currentWeapon.getCount());
        }

    }

    private boolean validHigherOrderWeapon(Weapon higherOrderWeapon, int remainingEnemyArsenal) {
        return higherOrderWeapon != null &&
                higherOrderWeapon.getCount() >= remainingEnemyArsenal / 2;
    }

    private boolean validLowerOrderWeapon(Weapon lowerOrderWeapon, int remainingEnemyArsenal) {
        return lowerOrderWeapon != null
                && lowerOrderWeapon.getCount() > 0
                && lowerOrderWeapon.getCount() >= remainingEnemyArsenal * 2;
    }

    private void finalOutcome(EnemyArsenal enemyArsenal, BattleResult battleResult) {
        if(battleResult.getHorseCount() >= enemyArsenal.getHorses()/2
        && battleResult.getElephantCount() >= enemyArsenal.getElephants()/2
        && battleResult.getArmedTanksCount() >= enemyArsenal.getArmouredTanks()/2
        && battleResult.getSlingShotCount() >= enemyArsenal.getSlingGuns()/2)
            battleResult.setBattleOutcome(ArmouryConstants.WINS);
        else
            battleResult.setBattleOutcome(ArmouryConstants.LOSES);

    }
}
