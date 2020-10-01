package com.example.demo.controllers;

import com.example.demo.models.Recipe;
import com.example.demo.models.Recipes;
import com.example.demo.services.FoodPlanService;
import com.example.demo.services.RecipeService;

import org.springframework.core.io.FileSystemResource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

import java.io.InputStream;
import java.util.ArrayList;

@Controller
public class MyController {
    Recipes recipes;
    FoodPlanService foodPlanService = new FoodPlanService();
    RecipeService recipeService = new RecipeService();
    String[] days = {"Mandag", "Tirsdag", "Onsdag", "Torsdag", "Fredag", "Lørdag", "Søndag"};

    @GetMapping("/")
    public String index(){
        return "index";

    }

    @GetMapping("/foodPlanner")
    public String foodPlanner(Model model){
        model.addAttribute("recipes", recipeService.recipes.getListOfRecipes());
        model.addAttribute("days", days);
        return "foodPlanner";
    }

    @PostMapping("/printFoodPlan")
    public String printFoodPlan(HttpServletRequest request, Model model) {
        String recipeName;
        String[] recipeNames = new String[7];
        String day;
        for (int i = 0; i < days.length; i++) {
            day = days[i];
            recipeName = request.getParameter(day);
            recipeNames[i] = recipeName;
        }
        ArrayList<Recipe> selectedRecipes = recipeService.getSelectedRecipes(recipeNames);
        foodPlanService.createPdf(selectedRecipes, days);
        model.addAttribute("recipes", selectedRecipes);
        model.addAttribute("days", days);
        return "printFoodPlan";
    }


    @GetMapping("/foodwaste")
    public String foodwaste(){
        return "foodwaste";

    }
    @GetMapping("/organisation")
    public String organisation(){
        return "organisation";
    }
}
