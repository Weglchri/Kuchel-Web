package at.kuchel.repostitory;

import at.kuchel.model.Image;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ImageRepository extends JpaRepository<Image, Long> {
    @Query("SELECT i FROM Image i WHERE i.recipe.id = ?1")
    List<Image> findByRecipeId(Long recipeId);
}
