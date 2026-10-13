package BattleRoyale.Character;


public class Mage extends Character {

    public Mage(String name) {
        super(name, 90, 30);
    }

    @Override
    public int attack() {
        if (random.nextInt(100) < 30) {
            System.out.println(name + " casts FIREBALL!");
            return attackDamage + 25 + random.nextInt(16);
        }

        System.out.println(name + " casts a magic bolt!");
        return attackDamage + random.nextInt(11);
    }
}

