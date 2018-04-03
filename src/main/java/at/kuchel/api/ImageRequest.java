package at.kuchel.api;

import lombok.Data;

import java.util.Date;

@Data
public class ImageRequest {

    private Long recipeId;
    private Date creationDate;
    private byte[] data;
}
