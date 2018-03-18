package at.kuchel.service.rest;

import at.kuchel.api.ImageDetailResponse;
import at.kuchel.mapper.ImageMapper;
import at.kuchel.model.Image;
import at.kuchel.model.Recipe;
import at.kuchel.repostitory.ImageRepository;
import at.kuchel.service.RecipeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ImageServiceApi {

    @Autowired
    private ImageRepository imageRepository;

    @Autowired
    private RecipeService recipeService;

    @Autowired
    private ImageMapper imageMapper;

    public ImageDetailResponse getImages(Long imageId) {
        Image image = imageRepository.findOne(imageId);
        return imageMapper.mapDetail(image);
    }

    public List<ImageDetailResponse> getImagesByRecipeId(Long recipeId) {
        Recipe recipe = recipeService.getRecipeById(recipeId);
        return recipe.getImages().stream().map(image -> imageMapper.mapDetail(image)).collect(Collectors.toList());
    }
}
