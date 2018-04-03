package at.kuchel.controller.rest;

import at.kuchel.Context;
import at.kuchel.api.ImageRequest;
import at.kuchel.service.rest.ImageServiceApi;
import org.slf4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.User;
import org.springframework.web.bind.annotation.*;

import static org.slf4j.LoggerFactory.getLogger;

@RestController
@RequestMapping(Context.REST_API + "images")
public class NewImageControllerApi {
    private static final Logger LOG = getLogger(NewImageControllerApi.class);

    private final ImageServiceApi imageService;

    public NewImageControllerApi(ImageServiceApi imageService) {
        this.imageService = imageService;
    }

    @ResponseStatus(HttpStatus.CREATED)
    @RequestMapping(method = RequestMethod.PUT)
    public void postImage(@AuthenticationPrincipal User user, @RequestBody ImageRequest imageRequest) {
        LOG.info("Got new Image from user '{}' for recipe '{}'", user.getUsername(), imageRequest.getRecipeId());
        imageService.storeImage(imageRequest, user);
    }
}
