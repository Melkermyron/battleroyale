package BattleRoyale.Character;

import java.util.Random;

    public class Character {

        protected String name;
        protected int health;
        protected int attackDamage;

        protected static final Random random = new Random();

        public Character(String name, int health, int attackDamage) {
            this.name = name;
            this.health = health;
            this.attackDamage = attackDamage;
        }

        public int attack() {
            return attackDamage;
        }

        public void takeDamage(int damage) {
            health -= damage;

            if (health < 0) {
                health = 0;
            }
        }

        public boolean isAlive() {
            return health > 0;
        }

        public String getName() {
            return name;
        }

        public int getHealth() {
            return health;
        }
    }


