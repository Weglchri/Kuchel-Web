package at.kuchel.controller;

import at.kuchel.service.RecipeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class DashController {

    @Autowired
    private RecipeService recipeService;

    @RequestMapping(value = {"/dashboard"}, method = RequestMethod.GET)
    public ModelAndView dashboard() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("recipe", recipeService.getRecommendationRecipe());
        modelAndView.setViewName("dashboard");
        return modelAndView;
    }

}
