package com.example.demo.services;

import java.io.Reader;
import java.io.File;
import java.nio.file.Files;
import java.util.ArrayList;

import com.example.demo.models.Recipe;
import com.example.demo.models.Recipes;
import com.google.gson.Gson;


public class RecipeService {
    public Recipes recipes;

    public RecipeService() {
        readRecipes();
    }

    private void readRecipes() {
        Gson gson = new Gson();
        String fileName = "recipes.json";
        try {

            ClassLoader classLoader = getClass().getClassLoader();
            //Dette gør, at json filen kan findes (getResources er prædefineret)
            File recipeFile = new File(classLoader.getResource(fileName).getFile());
            //Dette gør, at json filen kan læses
            Reader reader = Files.newBufferedReader(recipeFile.toPath());
            //Json filen bliver lavet om til et recipes objekt
            this.recipes = gson.fromJson(reader, Recipes.class);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public ArrayList<Recipe> getRecipes() {
        return recipes.getListOfRecipes();
    }

    public ArrayList<Recipe> getSelectedRecipes(String[] recipeNames) {
        ArrayList<Recipe> selectedRecipes = new ArrayList<>();
        for (String recipeName : recipeNames) {
            //Sætter (recipe objekterne) ind i et ArrayList selectedRecipe.
            selectedRecipes.add(recipes.getRecipe(recipeName));
        }
        return selectedRecipes;
    }

}
