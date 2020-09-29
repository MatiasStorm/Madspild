package com.example.demo.controllers;

import com.example.demo.models.Recipe;
import com.example.demo.models.Recipes;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;

@Controller
public class MyController {
    Recipes recipes = new Recipes();
    String[] days = {"Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday"};

    @GetMapping("/")
    public String index(){
        return "index";
    }

    @GetMapping("/foodPlanner")
    public String foodPlanner(Model model){
        model.addAttribute("recipes", recipes.getListOfRecipes());
        model.addAttribute("days", days);
        return "foodPlanner";
    }

    @PostMapping("/printFoodPlan")
    public String printFoodPlan(HttpServletRequest request, Model model) {
        String recipeName;
        Recipe recipe;
        ArrayList<Recipe> selectedRecipes = new ArrayList<>();
        for (String day : days) {
            recipeName = request.getParameter(day);
            recipe = recipes.getRecipe(recipeName);
            selectedRecipes.add(recipe);
        }
        model.addAttribute("recipes", selectedRecipes);
        model.addAttribute("days", days);
        return "printFoodPlan";
    }


}
