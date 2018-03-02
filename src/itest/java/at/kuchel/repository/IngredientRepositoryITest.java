package at.kuchel.repository;

import at.kuchel.model.Ingredient;
import at.kuchel.repostitory.IngredientRepository;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.hamcrest.Matchers.hasSize;

@RunWith(SpringRunner.class)
@SpringBootTest
public class IngredientRepositoryITest {

    @Autowired
    IngredientRepository ingredientRepository;

    @Test
    public void getUserByUsername() {
        List<Ingredient> ingredients = ingredientRepository.findByStatus(Ingredient.Status.NEW);
        Assert.assertThat(ingredients, hasSize(1));
    }
}
