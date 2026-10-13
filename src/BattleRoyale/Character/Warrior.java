package BattleRoyale.Character;


public class Warrior extends Character {

    public Warrior(String name) {
        super(name, 150, 20);
    }

    @Override
    public int attack() {
        int damage = attackDamage + random.nextInt(11);

        if (random.nextInt(100) < 25) {
            damage *= 2;
            System.out.println("SPECIAL ATTACK! Double damage!");
        } else {
            System.out.println(name + " swings a mighty sword!");
        }

        return damage;
    }
}

