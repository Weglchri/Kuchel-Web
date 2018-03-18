package at.kuchel.controller.rest;

import at.kuchel.Context;
import at.kuchel.api.ImageDetailResponse;
import at.kuchel.api.ImageSyncRequest;
import at.kuchel.service.rest.ImageServiceApi;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.slf4j.LoggerFactory.getLogger;

@RestController
@RequestMapping(Context.REST_API + "/recipes/{recipeId}/images")
public class ImageControllerApi {
    private static final Logger LOG = getLogger(ImageControllerApi.class);

    @Autowired
    private ImageServiceApi imageService;

    @RequestMapping(method = RequestMethod.POST)
    public List<ImageDetailResponse> getByImagesIds(@RequestBody ImageSyncRequest imageSyncRequest, @PathVariable Long recipeId) {
        LOG.info("Retrieve images with id '{}'", recipeId);
        return imageService.getImagesByRecipeId(imageSyncRequest, recipeId);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ImageDetailResponse getByImageId(@PathVariable Long recipeId, @PathVariable Long id) {
        LOG.info("Retrieve image for recipe '{}' with id '{}'", recipeId, id);
        return imageService.getImage(id);
    }
}
