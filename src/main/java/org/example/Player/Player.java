package org.example.Player;

public class Player {
    private double health;
    private double attack_dmg;
    private double dodge_chance;
    private double hit_chance;



    private double luck;
    private String name;

    public Player(String name, double health, double attack_dmg, double hit_chance, double dodge_chance, double luck){
        this.name = name;
        this.health = health;
        this.attack_dmg = attack_dmg;
        this.dodge_chance = dodge_chance;
        this.hit_chance = hit_chance;
        this.luck = luck;
    }

    public double getLuck() {
        return luck;
    }

    public void setLuck(double luck) {
        this.luck = luck;
    }

    public double getHealth() {
        return health;
    }

    public void setHealth(double health) {
        this.health = health;
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

    public double getHit_chance() {
        return hit_chance;
    }

    public void setHit_chance(double hit_chance) {
        this.hit_chance = hit_chance;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }





}
