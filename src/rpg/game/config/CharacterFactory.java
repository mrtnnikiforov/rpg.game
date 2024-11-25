package rpg.game.config;

import rpg.game.character.custom.*;

public class CharacterFactory {
    public static final int DEFAULT_AMAZONIAN_POWER = 7;
    public static final int DEFAULT_BARBARIAN_POWER = 9;
    public static final int DEFAULT_NECROMANCER_POWER = 3;
    public static final int DEFAULT_PALADIN_POWER = 5;
    public static final int DEFAULT_WITCH_POWER = 5;
    public static final int FULL_HEALTH = 100;
    public static final String DEFAULT_AMAZONIAN_RACE = "Elf";
    public static final String DEFAULT_PALADIN_RACE = "Human";
    public static final String DEFAULT_BARBARIAN_RACE = "Orc";
    public static final String DEFAULT_NECROMANCER_RACE = "Midget";
    public static final String DEFAULT_WITCH_RACE = "Blood Elf";

    public static Amazonian createDefaultAmazonian(String name) {
        return new Amazonian(
                name,
                FULL_HEALTH,
                DEFAULT_AMAZONIAN_POWER,
                DEFAULT_AMAZONIAN_RACE
        );
    }

    public static Barbarian createDefaultBarbarian(String name) {
        return new Barbarian(
                name,
                FULL_HEALTH,
                DEFAULT_BARBARIAN_POWER,
                DEFAULT_BARBARIAN_RACE
        );
    }

    public static Necromancer createDefaultNecromancer(String name) {
        return new Necromancer(
                name,
                FULL_HEALTH,
                DEFAULT_NECROMANCER_POWER,
                DEFAULT_NECROMANCER_RACE
        );
    }

    public static Paladin createDefaultPaladin(String name) {
        return new Paladin(
                name,
                FULL_HEALTH,
                DEFAULT_PALADIN_POWER,
                DEFAULT_PALADIN_RACE
        );
    }

    public static Witch createDefaultWitch(String name) {
        return new Witch(
                name,
                FULL_HEALTH,
                DEFAULT_WITCH_POWER,
                DEFAULT_WITCH_RACE
        );
    }
}
