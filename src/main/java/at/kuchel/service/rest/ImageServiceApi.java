package at.kuchel.service.rest;

import at.kuchel.api.ImageDetailResponse;
import at.kuchel.api.ImageRequest;
import at.kuchel.exception.KuchelApiException;
import at.kuchel.mapper.ImageMapper;
import at.kuchel.model.Recipe;
import at.kuchel.repostitory.ImageRepository;
import at.kuchel.repostitory.RecipeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Service;

import java.util.Date;

import static at.kuchel.exception.KuchelErrorCode.RECIPE_BELONGS_TO_ANOTHER_USER;
import static at.kuchel.exception.KuchelErrorCode.RECIPE_NOT_FOUND;

@Service
public class ImageServiceApi {

    private final ImageRepository imageRepository;

    private final RecipeRepository recipeRepository;

    private final ImageMapper imageMapper;

    @Autowired
    public ImageServiceApi(ImageRepository imageRepository, RecipeRepository recipeRepository, ImageMapper imageMapper) {
        this.imageRepository = imageRepository;
        this.recipeRepository = recipeRepository;
        this.imageMapper = imageMapper;
    }

    public ImageDetailResponse getImage(Long imageId) {
        return imageMapper.mapDetail(imageRepository.findOne(imageId));
    }

    public void storeImage(ImageRequest imageRequest,  User user) {
        //todo some validation later on
        Recipe recipe = recipeRepository.findOne(imageRequest.getRecipeId());

        if (recipe == null) {
            throw new KuchelApiException(RECIPE_NOT_FOUND);
        } else if (recipe.getUser().getUsername().equals(user.getUsername())) {
            imageRepository.save(imageMapper.mapToEntity(imageRequest, recipe));
            recipe.setModifiedDate(new Date());
            recipeRepository.save(recipe);
        } else {
            throw new KuchelApiException(RECIPE_BELONGS_TO_ANOTHER_USER);
        }
    }
}
