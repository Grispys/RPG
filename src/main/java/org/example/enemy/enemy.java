package org.example.enemy;

public class enemy {
    private double health;
    private String name;
    private double dodge_chance;
    private double attack_dmg;

    public enemy(double health, String name, double dodge_chance, double attack_dmg){
        this.health = health;
        this.name = name;
        this.dodge_chance = dodge_chance;
        this.attack_dmg = attack_dmg;
    }

    public double getHealth() {
        return health;
    }

    public void setHealth(double health) {
        this.health = health;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public double getAttack_dmg() {
        return attack_dmg;
    }

    public void setAttack_dmg(double attack_dmg) {
        this.attack_dmg = attack_dmg;
    }

    public double getDodge_chance() {
        return dodge_chance;
    }

    public void setDodge_chance(double dodge_chance) {
        this.dodge_chance = dodge_chance;
    }

}
