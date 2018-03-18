package at.kuchel.mapper;

import at.kuchel.api.ImageResponse;
import at.kuchel.model.Image;
import org.springframework.stereotype.Service;

import java.util.Base64;

@Service
public class ImageMapper {

    public ImageResponse mapDetail(Image image) {
        ImageResponse imageResponse = new ImageResponse();
        imageResponse.setId(String.valueOf(image.getId()));
        imageResponse.setName(image.getName());
        imageResponse.setData(Base64.getEncoder().encode(image.getData()));
        return imageResponse;
    }

    public ImageResponse mapOverview(Image image) {
        ImageResponse imageResponse = new ImageResponse();
        imageResponse.setId(String.valueOf(image.getId()));
//        imageResponse.setModifiedDate(image.getModifiedDate());
        return imageResponse;
    }
}
