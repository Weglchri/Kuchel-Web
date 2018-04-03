package at.kuchel.service.rest;

import at.kuchel.api.ImageDetailResponse;
import at.kuchel.api.ImageIdsRequest;
import at.kuchel.api.ImageRequest;
import at.kuchel.api.LastSyncDateRequest;
import at.kuchel.exception.KuchelApiException;
import at.kuchel.mapper.ImageMapper;
import at.kuchel.model.Image;
import at.kuchel.model.Recipe;
import at.kuchel.repostitory.ImageRepository;
import at.kuchel.repostitory.RecipeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

import static at.kuchel.exception.KuchelErrorCode.RECIPE_BELONGS_TO_ANOTHER_USER;
import static at.kuchel.exception.KuchelErrorCode.RECIPE_NOT_FOUND;

@Service
public class ImageServiceApi {

    @Autowired
    private ImageRepository imageRepository;

    @Autowired
    private RecipeRepository recipeRepository;

    @Autowired
    private ImageMapper imageMapper;

    public ImageDetailResponse getImage(Long imageId) {
        return imageMapper.mapDetail(imageRepository.findOne(imageId));
    }

    public List<ImageDetailResponse> getImagesByRecipeId(ImageIdsRequest imageSyncRequest, Long recipeId) {
        List<Image> images = imageRepository.findByRecipeId(recipeId);
        return images.stream().filter(image -> imageSyncRequest.getImageIds().contains(image.getRecipe().getId().toString()))
                .map(image -> imageMapper.mapDetail(image)).collect(Collectors.toList());
    }

    public List<ImageDetailResponse> getImagesByRecipeId(Long recipeId) {
        return imageRepository.findByRecipeId(recipeId).stream().map(image -> imageMapper.mapDetail(image)).collect(Collectors.toList());
    }

    public ImageDetailResponse getImageWithLastSyncDate(Long id, LastSyncDateRequest lastSyncDateRequest) {
        ImageDetailResponse image = getImage(id);
        return image.getModifiedDate().after(lastSyncDateRequest.getLastSyncDate()) ? image : null;
    }

    public void storeImage(ImageRequest imageRequest,  User user) {
        //todo some validation later on
        Recipe recipe = recipeRepository.findOne(imageRequest.getRecipeId());

        if (recipe == null) {
            throw new KuchelApiException(RECIPE_NOT_FOUND);
        } else if (recipe.getUser().getUsername().equals(user.getUsername())) {
            imageRepository.save(imageMapper.mapToEntity(imageRequest, recipe));
        } else {
            throw new KuchelApiException(RECIPE_BELONGS_TO_ANOTHER_USER);
        }
    }
}
