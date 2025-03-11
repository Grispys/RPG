package org.example;

import org.example.Player.Player;
import org.example.enemy.enemy;

import java.sql.SQLOutput;
import org.example.item.item;
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
            scanner.nextLine();

            switch (choice) {
                case 1:
                    attack();
                    break;
                case 2:
                    guard();
                    break;
                case 3:
                    item();
                    break;
                case 4:
                    System.out.println("There's no opening! ");
                    break;
                default:
                    System.out.println("What to do...");

            }
            if(!finished){
                enemy_attack(enemy);
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

    public void guard(){
        System.out.println("You brace for impact...");
        user.setGuard(0.25);
    }

    public void item(){
        System.out.println(user.getInventory());
        System.out.println("Should I use something? : ");
        String choice2 = scanner.nextLine();
        for(int i=0; i < user.getInventory().size(); i++){
            choice2 = choice2.substring(0,1).toUpperCase() + choice2.substring(1);
            if(choice2.equals(user.getInventory().get(i).getName())){
                System.out.println("You consumed the " + user.getInventory().get(i).getName() + "!");
            }
            else{
                System.out.println("I don't have one...");
            }
        }
    }


    public void enemy_attack(enemy enemy) throws InterruptedException {
        double chance = (1 + Math.random() * enemy.getLuck());
        double damage =  (enemy.getAttack_dmg() * (chance - user.getGuard()));
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
        user.setGuard(0.00);
    }


    public static void main(String[] args) throws InterruptedException {
        Player user = new Player("Hero", 100.00, 10.0, .05, 0.15, 1.05, 0.00);
        enemy enemy = new enemy(100.0, "Slime", .15, 7.0, 1.06);
        item apple = new item("Apple", "Heals you for 25 health.");
        user.setInventory(apple);
        Main game = new Main();

        System.out.println("What's up dude this is your basic RPG fight testing lounge. You have your name, Health, attack, hit/dodge chance.");
        System.out.println("inventory:");
        System.out.println(user.getInventory());

        game.fighting(enemy, user);


    }
}