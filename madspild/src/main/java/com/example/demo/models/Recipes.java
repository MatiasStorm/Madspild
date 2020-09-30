package com.example.demo.models;

import java.util.ArrayList;

public class Recipes {

    ArrayList<Recipe> listOfRecipes = new ArrayList<>();



    public Recipes(ArrayList<Recipe> listOfRecipes) {
        this.listOfRecipes = listOfRecipes;
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
