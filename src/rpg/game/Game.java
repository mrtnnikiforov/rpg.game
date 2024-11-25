package rpg.game;

import rpg.game.character.Character;
import rpg.game.monster.*;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;
import java.util.Scanner;

import static rpg.game.config.CharacterFactory.*;
import static rpg.game.config.MonsterFactory.*;

public class Game {
    private Character hero;
    private Queue<rpg.game.monster.Monster> monsters;

    public Game() {
        monsters = new LinkedList<>();
    }

    public void createHero(String name, String race) {
        switch (race) {
            case "Elf":
                this.hero = createDefaultAmazonian(name);
                break;
            case "Human":
                this.hero = createDefaultPaladin(name);
                break;
            case "Orc":
                this.hero = createDefaultBarbarian(name);
                break;
            case "Midget":
                this.hero = createDefaultNecromancer(name);
                break;
            case "Blood Elf":
                this.hero = createDefaultWitch(name);
                break;
            default:
                throw new IllegalArgumentException("Unknown race: " + race);
        }
        System.out.printf("Hero %s of race %s created!\n", name, race);
    }

    public static Monster createRandomMonster() {
        Random random = new Random();
        int monsterType = random.nextInt(3);
        String randomName = "Monster_" + random.nextInt(1000);

        return switch (monsterType) {
            case 0 -> createDefaultButcher(randomName);
            case 1 -> createDefaultSkeletonKing(randomName);
            case 2 -> createDefaultFallenShaman(randomName);
            default -> throw new IllegalStateException("Unexpected value: " + monsterType);
        };
    }

    public void addMonster(Monster monster) {
        monsters.offer(monster);
        System.out.printf("Monster %s added to the battle queue!\n", monster.getName());
    }

    public void startBattle() {
        while (!monsters.isEmpty() && hero.getHealth() > 0) {
            Monster currentMonster = monsters.poll();
            assert currentMonster != null;
            System.out.printf("%s encounters %s!\n", hero.getName(), currentMonster.getName());

            battle(currentMonster);

            if (hero.getHealth() > 0) {
                recover();
            }
        }

        if (hero.getHealth() <= 0) {
            System.out.printf("%s has been defeated!\n", hero.getName());
        } else {
            System.out.printf("%s has defeated all monsters!\n", hero.getName());
        }
    }

    private void battle(Monster monster) {
        while (hero.getHealth() > 0 && monster.getHealth() > 0) {
            hero.attack(monster);

            if (monster.getHealth() > 0) {
                monster.attack(hero);
            }
        }
    }

    public void recover() {
        System.out.println("Recovering hero's strength...");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        hero.heal(hero, 20);
        System.out.printf("%s has recovered strength! Current health: %d\n", hero.getName(), hero.getHealth());
    }

    public static void main(String[] args) {
        Game game = new Game();
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter hero name: ");
        String heroName = scanner.nextLine();
        System.out.print("Enter hero race: ");
        String heroRace = scanner.nextLine();
        game.createHero(heroName, heroRace);

        System.out.println("Adding monsters to the battle...");
        for (int i = 0; i < 3; i++) {
            Monster monster = createRandomMonster();
            game.addMonster(monster);
        }

        game.startBattle();

        scanner.close();
    }
}
