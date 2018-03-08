package at.kuchel.repostitory;

import at.kuchel.model.Ingredient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IngredientRepository extends JpaRepository<Ingredient, Long> {
    List<Ingredient> findByStatus(Ingredient.Status status);
    Ingredient findByName(String name);
}
