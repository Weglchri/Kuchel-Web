package at.kuchel.repostitory;

import at.kuchel.model.Recipe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RecipeRepository extends JpaRepository<Recipe, Long> {
    //@Query("select r from Recipe r where r.username = :username")
    //List<Recipe> findByUsername(String username);
}
