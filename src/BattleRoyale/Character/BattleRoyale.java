package BattleRoyale.Character;


import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class BattleRoyale {

    public static void main(String[] args) {

        Random random = new Random();

        // Skapa alla karaktärer
        List<Character> players = new ArrayList<>();

        players.add(new Warrior("Thor"));
        players.add(new Mage("Gandalf"));
        players.add(new Archer("Legolas"));
        players.add(new Tank("Hulk"));

        System.out.println("================================");
        System.out.println("       BATTLE ROYALE");
        System.out.println("================================");
        System.out.println();

        for (Character player : players) {
            System.out.println(player.getName()
                    + " enters with "
                    + player.getHealth() + " HP!");
        }

        int round = 1;

        // Spelet fortsätter tills bara en lever
        while (countAlive(players) > 1) {

            System.out.println("\n================================");
            System.out.println("           ROUND " + round);
            System.out.println("================================");

            for (Character attacker : players) {

                // Död karaktär får inte attackera
                if (!attacker.isAlive()) {
                    continue;
                }

                // Hitta levande motståndare
                List<Character> opponents = new ArrayList<>();

                for (Character player : players) {
                    if (player.isAlive() && player != attacker) {
                        opponents.add(player);
                    }
                }

                if (opponents.isEmpty()) {
                    break;
                }

                // Välj en slumpmässig motståndare
                Character target = opponents.get(
                        random.nextInt(opponents.size())
                );

                System.out.println("\n" + attacker.getName()
                        + " attacks " + target.getName() + "!");

                // Rätt attackmetod väljs genom polymorfism
                int damage = attacker.attack();

                // Spara hälsan före attacken
                int oldHealth = target.getHealth();

                // Utför attacken
                target.takeDamage(damage);

                // Beräkna faktisk förlorad hälsa
                int actualDamage = oldHealth - target.getHealth();

                System.out.println("Actual damage: " + actualDamage);
                System.out.println(target.getName()
                        + " has " + target.getHealth() + " HP left.");

                if (!target.isAlive()) {
                    System.out.println();
                    System.out.println("*** "
                            + target.getName()
                            + " HAS BEEN ELIMINATED! ***");
                }

                // Avsluta striden direkt om bara en lever
                if (countAlive(players) <= 1) {
                    break;
                }
            }

            // Visa vilka som lever efter rundan
            if (countAlive(players) > 1) {
                printSurvivors(players);
            }

            round++;
        }

        // Slutskärm
        System.out.println("\n");
        System.out.println("================================");
        System.out.println("       BATTLE ROYALE OVER");
        System.out.println("================================");

        for (Character player : players) {
            if (player.isAlive()) {
                System.out.println();
                System.out.println("*******************************");
                System.out.println("       THE WINNER IS...");
                System.out.println("          " + player.getName().toUpperCase() + "!");
                System.out.println("       Remaining HP: "
                        + player.getHealth());
                System.out.println("*******************************");
            }
        }

        System.out.println();
        System.out.println("Total rounds: " + (round - 1));
        System.out.println("Thanks for playing!");
    }

    // Räknar antalet levande karaktärer
    public static int countAlive(List<Character> players) {

        int count = 0;

        for (Character player : players) {
            if (player.isAlive()) {
                count++;
            }
        }

        return count;
    }

    // Skriver ut alla överlevande
    public static void printSurvivors(List<Character> players) {

        System.out.println("\n--- SURVIVORS ---");

        for (Character player : players) {
            if (player.isAlive()) {
                System.out.println(player.getName()
                        + ": " + player.getHealth() + " HP");
            }
        }

        System.out.println("-----------------");
    }
}
