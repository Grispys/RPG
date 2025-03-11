package org.example.item;

public class item {
    private String name;
    private String description;
    private double effect;
    public item(String name, String description, double effect){
        this.description = description;
        this.name = name;
        this.effect = effect;
    }

    public double getEffect() {
        return effect;
    }

    public void setEffect(double effect) {
        this.effect = effect;
    }


    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString(){
        return "Item: " + this.getName() + ": " + this.getDescription();
    }
}
