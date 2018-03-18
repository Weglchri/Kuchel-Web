package at.kuchel.service.rest;

import at.kuchel.api.ImageDetailResponse;
import at.kuchel.api.ImageSyncRequest;
import at.kuchel.mapper.ImageMapper;
import at.kuchel.model.Image;
import at.kuchel.repostitory.ImageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ImageServiceApi {

    @Autowired
    private ImageRepository imageRepository;


    @Autowired
    private ImageMapper imageMapper;

    public ImageDetailResponse getImage(Long imageId) {
        Image image = imageRepository.findOne(imageId);
        return imageMapper.mapDetail(image);
    }

    public List<ImageDetailResponse> getImagesByRecipeId(ImageSyncRequest imageSyncRequest, Long recipeId) {
        List<Image> images = imageRepository.findByRecipeId(recipeId);
        return images.stream().filter(image -> imageSyncRequest.getImageIds().contains(image.getRecipe().getId().toString()))
                .map(image -> imageMapper.mapDetail(image)).collect(Collectors.toList());
    }
}
