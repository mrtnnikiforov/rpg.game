package rpg.game.config;

import rpg.game.monster.Butcher;
import rpg.game.monster.FallenShaman;
import rpg.game.monster.SkeletonKing;

public class MonsterFactory {
    public static final int DEFAULT_FALLEN_SHAMAN_POWER = 7;
    public static final int DEFAULT_SKELETON_KING_POWER = 9;
    public static final int DEFAULT_BUTCHER_POWER = 3;
    public static final int FULL_HEALTH = 100;
    public static final String DEFAULT_FALLEN_SHAMAN_RACE = "Demon";
    public static final String DEFAULT_SKELETON_KING_RACE = "Undead";
    public static final String DEFAULT_BUTCHER_RACE = "Beast";

    public static FallenShaman createDefaultFallenShaman(String name){
        return new FallenShaman(
                name,
                FULL_HEALTH,
                DEFAULT_FALLEN_SHAMAN_POWER,
                DEFAULT_FALLEN_SHAMAN_RACE
        );
    }

    public static SkeletonKing createDefaultSkeletonKing(String name){
        return new SkeletonKing(
                name,
                FULL_HEALTH,
                DEFAULT_SKELETON_KING_POWER,
                DEFAULT_SKELETON_KING_RACE
        );
    }

    public static Butcher createDefaultButcher(String name){
        return new Butcher(
                name,
                FULL_HEALTH,
                DEFAULT_BUTCHER_POWER,
                DEFAULT_BUTCHER_RACE
        );
    }
}
