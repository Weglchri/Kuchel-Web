package at.kuchel.controller.rest;

import at.kuchel.Context;
import at.kuchel.api.ImageDetailResponse;
import at.kuchel.api.ImageIdsRequest;
import at.kuchel.api.LastSyncDateRequest;
import at.kuchel.service.rest.ImageServiceApi;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.slf4j.LoggerFactory.getLogger;

@RestController
@RequestMapping(Context.REST_API + "recipes/{recipeId}/images")
public class ImageControllerApi {
    private static final Logger LOG = getLogger(ImageControllerApi.class);

    private final ImageServiceApi imageService;

    @Autowired
    public ImageControllerApi(ImageServiceApi imageService) {
        this.imageService = imageService;
    }

    @RequestMapping(method = RequestMethod.GET)
    public List<ImageDetailResponse> getByImagesIds(@PathVariable Long recipeId) {
        LOG.info("Retrieve images with id '{}'", recipeId);
        return imageService.getImagesByRecipeId(recipeId);
    }

    @RequestMapping(method = RequestMethod.POST)
    public List<ImageDetailResponse> getByImagesIds(@RequestBody ImageIdsRequest imageSyncRequest, @PathVariable Long recipeId) {
        LOG.info("Retrieve images with ImageIdsRequest and id '{}'", recipeId);
        return imageService.getImagesByRecipeId(imageSyncRequest, recipeId);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ImageDetailResponse getByImageId(@PathVariable Long recipeId, @PathVariable Long id) {
        LOG.info("Retrieve image for recipe '{}' with id '{}'", recipeId, id);
        return imageService.getImage(id);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.POST)
    public ImageDetailResponse getByImageId(@PathVariable Long recipeId, @PathVariable Long id, @RequestBody LastSyncDateRequest lastSyncDateRequest) {
        LOG.info("Retrieve image for recipe '{}' with id '{}'", recipeId, id);
        return imageService.getImageWithLastSyncDate(id, lastSyncDateRequest);
    }
}
