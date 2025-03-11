package org.example.Player;

import org.example.item.item;

import java.util.ArrayList;

public class Player {
    private double health;
    private double attack_dmg;
    private double dodge_chance;
    private double hit_chance;
    private double guard;
    private final ArrayList<item> inventory;



    private double luck;
    private String name;

    public Player(String name, double health, double attack_dmg, double hit_chance, double dodge_chance, double luck, double guard){
        this.name = name;
        this.health = health;
        this.attack_dmg = attack_dmg;
        this.dodge_chance = dodge_chance;
        this.hit_chance = hit_chance;
        this.luck = luck;
        this.guard = guard;
        this.inventory = new ArrayList<item>();
    }


    public ArrayList<item> getInventory() {
        return inventory;
    }

    public void setInventory(item item) {
        this.inventory.add(item);
    }

    public void removeInventory(item item){
        this.inventory.remove(item);
    }



    public double getGuard() {
        return guard;
    }

    public void setGuard(double guard) {
        this.guard = guard;
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
