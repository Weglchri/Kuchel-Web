package at.kuchel.mapper;

import at.kuchel.api.ImageDetailResponse;
import at.kuchel.api.ImageOverviewResponse;
import at.kuchel.api.ImageRequest;
import at.kuchel.model.Image;
import at.kuchel.model.Recipe;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class ImageMapper {

    public ImageDetailResponse mapDetail(Image image) {
        ImageDetailResponse imageResponse = new ImageDetailResponse();
        imageResponse.setId(String.valueOf(image.getId()));
        imageResponse.setData(image.getData());
        imageResponse.setModifiedDate(image.getModifiedDate());
        return imageResponse;
    }

    public ImageOverviewResponse mapOverview(Image image) {
        ImageOverviewResponse imageResponse = new ImageOverviewResponse();
        imageResponse.setId(String.valueOf(image.getId()));
        imageResponse.setModifiedDate(image.getModifiedDate());
        return imageResponse;
    }

    public Image mapToEntity(ImageRequest imageRequest, Recipe recipe) {
        Image image = new Image();
        image.setModifiedDate(new Date());
        image.setData(imageRequest.getData());
        image.setRecipe(recipe);
        return image;
    }
}
