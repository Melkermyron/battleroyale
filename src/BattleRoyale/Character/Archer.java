package BattleRoyale.Character;


public class Archer extends Character {

    public Archer(String name) {
        super(name, 100, 22);
    }

    @Override
    public int attack() {
        int damage = attackDamage + random.nextInt(11);

        if (random.nextInt(100) < 30) {
            damage *= 2;
            System.out.println(name + " scores a CRITICAL HIT!");
        } else {
            System.out.println(name + " shoots an arrow!");
        }

        return damage;
    }
}

