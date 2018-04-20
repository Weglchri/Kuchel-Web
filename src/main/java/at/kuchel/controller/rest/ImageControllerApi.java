package at.kuchel.controller.rest;

import at.kuchel.Context;
import at.kuchel.api.ImageDetailResponse;
import at.kuchel.api.ImageRequest;
import at.kuchel.service.rest.ImageServiceApi;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.User;
import org.springframework.web.bind.annotation.*;

import static org.slf4j.LoggerFactory.getLogger;

@RestController
@RequestMapping(Context.REST_API + "images")
public class ImageControllerApi {
    private static final Logger LOG = getLogger(ImageControllerApi.class);

    private final ImageServiceApi imageService;

    @Autowired
    public ImageControllerApi(ImageServiceApi imageService) {
        this.imageService = imageService;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ImageDetailResponse getByImageId(@PathVariable Long id) {
        LOG.info("Retrieve image with id '{}'", id);
        return imageService.getImage(id);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @RequestMapping(method = RequestMethod.PUT)
    public void postImage(@AuthenticationPrincipal User user, @RequestBody ImageRequest imageRequest) {
        LOG.info("Got new Image from user '{}' for recipe '{}'", user.getUsername(), imageRequest.getRecipeId());
        imageService.storeImage(imageRequest, user);
    }
}
