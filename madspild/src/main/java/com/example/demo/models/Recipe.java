package com.example.demo.models;

import java.util.ArrayList;

public class Recipe {
    String name;
    ArrayList<Ingredient> ingredients = new ArrayList<>();

    public Recipe(String name){
        this.name = name;
    }

    public void addIngredient(Ingredient i){
        ingredients.add(i);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Ingredient> getIngredients() {
        return ingredients;
    }

    public void setIngredients(ArrayList<Ingredient> ingredients) {
        this.ingredients = ingredients;
    }
}
