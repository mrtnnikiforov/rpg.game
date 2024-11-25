package rpg.game.character.custom;

import rpg.game.character.Character;
import rpg.game.monster.Monster;

public class Barbarian extends Character {
    @Override
    public void attack(Monster target) {
        var healthAfterAttack = target.getHealth() - getPower();
        target.setHealth(healthAfterAttack);
        if (healthAfterAttack <= 0){
            System.out.printf("%s was slain by %s\n", target.getName(), getName());
        }
        else {
            System.out.printf("%s dealt %d damage to %s, remaining health of %s: %d\n", getName(), getPower(), target.getName(), target.getName(), target.getHealth());
        }
    }

    public Barbarian(String name, int health, int power, String race) {
        super(name, health, power, race);
    }
}
