package at.kuchel.api;

import lombok.Data;

@Data
public class ImageResponse {

    private String id;
    private String name;
    private byte[] data;

}
