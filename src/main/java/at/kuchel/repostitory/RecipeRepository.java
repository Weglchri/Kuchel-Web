package at.kuchel.repostitory;

import at.kuchel.model.Recipe;
import at.kuchel.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RecipeRepository extends JpaRepository<Recipe, Long> {
    //TODO: implement individual search method
    List<Recipe> findRecipeByUser(User user);
    Recipe findByName(String name);
}
