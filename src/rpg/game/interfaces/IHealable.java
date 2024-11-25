package rpg.game.interfaces;

import rpg.game.character.Character;

public interface IHealable {
    public void heal(Character character, int amount);
}
