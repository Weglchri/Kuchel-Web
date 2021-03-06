package at.kuchel.api;

import lombok.Data;

import java.util.Date;

@Data
public class ImageDetailResponse {

    private String id;
    private Date modifiedDate;
    private byte[] data;
}
