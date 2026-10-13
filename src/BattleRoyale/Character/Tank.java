package BattleRoyale.Character;


public class Tank extends Character {

    public Tank(String name) {
        super(name, 200, 15);
    }

    @Override
    public int attack() {
        int damage = attackDamage + random.nextInt(6);

        System.out.println(name + " smashes the enemy with a hammer!");

        return damage;
    }

    @Override
    public void takeDamage(int damage) {
        int reducedDamage = Math.max(1, damage - 5);

        System.out.println(name + "'s armor reduces the damage by "
                + (damage - reducedDamage) + "!");

        super.takeDamage(reducedDamage);
    }
}
