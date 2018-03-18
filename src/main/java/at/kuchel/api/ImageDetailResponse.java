package at.kuchel.api;

import lombok.Data;

import java.time.LocalDate;

@Data
public class ImageDetailResponse {

    private String id;
    private LocalDate modifiedDate;
    private byte[] data;
}
