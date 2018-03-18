package at.kuchel.mapper;

import at.kuchel.api.ImageDetailResponse;
import at.kuchel.api.ImageOverviewResponse;
import at.kuchel.model.Image;
import org.springframework.stereotype.Service;

import java.util.Base64;

@Service
public class ImageMapper {

    public ImageDetailResponse mapDetail(Image image) {
        ImageDetailResponse imageResponse = new ImageDetailResponse();
        imageResponse.setId(String.valueOf(image.getId()));
        imageResponse.setData(Base64.getEncoder().encode(image.getData()));
        imageResponse.setModifiedDate(image.getModifiedDate());
        return imageResponse;
    }

    public ImageOverviewResponse mapOverview(Image image) {
        ImageOverviewResponse imageResponse = new ImageOverviewResponse();
        imageResponse.setId(String.valueOf(image.getId()));
        imageResponse.setModifiedDate(image.getModifiedDate());
        return imageResponse;
    }
}
