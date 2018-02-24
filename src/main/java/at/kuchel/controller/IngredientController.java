package at.kuchel.controller;

import at.kuchel.service.IngredientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class IngredientController {

    @Autowired
    private IngredientService ingredientService;


    @RequestMapping(value = "/ingredient", method = RequestMethod.GET)
    public String getIngredientsStartWith(Model model) {
//TODO fix this
//        System.out.println("searchString: " + searchString);
//        model.addAttribute("ingredient", ingredientService.getIngredientsStartsWith());
        return "ingredient";
    }
}
