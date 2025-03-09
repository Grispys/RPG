package org.example;

import org.example.Player.Player;
import org.example.enemy.enemy;

import java.sql.SQLOutput;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class Main {
    static Scanner  scanner = new Scanner(System.in);
    Player user;
    enemy enemy;
    boolean finished = false;


    public void fighting(enemy enemy, Player player) throws InterruptedException {
        this.enemy = enemy;
        this.user = player;
       finished = false;
        while(true){
            if(finished){
                System.out.println("You win!");
                break;
            }

            System.out.println("=~= It's Your Turn =~=");
            System.out.println("    === FIGHT! ===   ");
            System.out.println("1. Attack ");
            System.out.println("2. Guard ");
            System.out.println("3. Item ");
            System.out.println("4. Run ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    attack();
                    break;

                case 2:
                    break;
                case 3:
                    System.out.println("Your bag is empty. ");
                    break;
                case 4:
                    System.out.println("There's no opening! ");
                    break;
                default:
                    System.out.println("What to do...");

            }
            if(!finished){
                enemy_attack();
            }


        }
    }



    public void attack(){
//        fight out the damage that would be done
        double chance = (1 + Math.random() * user.getLuck());
        double damage =  (user.getAttack_dmg() * chance);
        damage = Math.floor(damage);
        double dodge = (Math.random()+ enemy.getDodge_chance());
        System.out.println(dodge+ "%");
//        use if statement to see if hit chance, along with enemy dodge chance, allows the hit to go through
        double result = enemy.getHealth() - damage;
        if(dodge <=.95){
            enemy.setHealth(result);
            if(enemy.getHealth() <= 0 ){
                System.out.println("You just dealt " + damage + " damage to " + enemy.getName() + ", and it died!");
                finished = true;
            } else{
                System.out.println("You just dealt " + damage + " damage to " + enemy.getName() + ". It's now at " + enemy.getHealth() + " health!");
            }
        } else{
            System.out.println("Your attack missed!");
        }

    }

    public void enemy_attack() throws InterruptedException {
        double chance = (1 + Math.random() * enemy.getLuck());
        double damage =  (user.getAttack_dmg() * chance);
        damage = Math.floor(damage);
        double dodge = (Math.random()+ enemy.getDodge_chance());
        double result = user.getHealth() - damage;
        TimeUnit.SECONDS.sleep(1);
        System.out.println("The " + enemy.getName() + " is getting ready to attack!");
        TimeUnit.SECONDS.sleep(1);
        if(dodge <=.60){
            user.setHealth(result);
            if(user.getHealth() <= 0 ){
                System.out.println("It hit you for " + damage + ", and you died!");
            } else{
                System.out.println("It hit you for " + damage + ". You're " + user.getHealth() + " health!");
            }
        } else{
            System.out.println("The " + enemy.getName() + "'s attack missed!");
        }
    }


    public static void main(String[] args) throws InterruptedException {
        Player user = new Player("Hero", 100.00, 10.0, .05, 0.15, 1.05);
        enemy enemy = new enemy(100.0, "Slime", .15, 7.0, 1.06);
        Main game = new Main();

        System.out.println("What's up dude this is your basic RPG fight testing lounge. You have your name, Health, attack, hit/dodge chance.");
        game.fighting(enemy, user);

    }
}