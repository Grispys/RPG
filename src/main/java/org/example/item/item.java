package org.example.item;

public class item {
    private String name;
    private String description;

    public item(String name, String description){
        this.description = description;
        this.name = name;
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
