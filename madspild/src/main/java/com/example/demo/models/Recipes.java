package com.example.demo.models;

import java.util.ArrayList;

public class Recipes {

    ArrayList<Recipe> listOfRecipes = new ArrayList<>();

    public void createRecipe(String name){
        Recipe lasagne = new Recipe(name);
        lasagne.addIngredient(new Ingredient("Ground beef", 500, "gram"));
        lasagne.addIngredient(new Ingredient("Pasta", 500, "gram"));
        lasagne.addIngredient(new Ingredient("Salt", 5, "gram"));
        lasagne.addIngredient(new Ingredient("Onion", 2, "pieces"));
        lasagne.addIngredient(new Ingredient("Copped tomatoes", 500, "gram"));
        lasagne.addIngredient(new Ingredient("Carrots", 200, "gram"));
        listOfRecipes.add(lasagne);
    }

    public Recipes() {
        String[] names = {"Lagsagne", "Pizza", "Bøf bernaise", "Bacon and potatoes", "Tomatoes", "Dild"};
        for(String name : names){
            createRecipe(name);
        }
    }

    public ArrayList<Recipe> getListOfRecipes(){
        return listOfRecipes;
    }

    public Recipe getRecipe(String recipeName){
        for(Recipe recipe : listOfRecipes){
            if(recipe.getName().equalsIgnoreCase(recipeName)){
                return recipe;
            }
        }
        return null;
    }
}
