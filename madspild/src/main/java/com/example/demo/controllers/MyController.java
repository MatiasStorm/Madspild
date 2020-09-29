package com.example.demo.controllers;

import com.example.demo.models.Recipe;
import com.example.demo.models.Recipes;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.Arrays;

@Controller
public class MyController {
    Recipes recipes = new Recipes();
    ArrayList<String> days = new ArrayList(
            Arrays.asList("Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday")
    );

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
        model.addAttribute("firstHalfWeek", days.subList(0, 4));
        model.addAttribute("lastHalfWeek", days.subList(4,7));
        return "printFoodPlan";
    }


}
