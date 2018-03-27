package at.kuchel.api;

import lombok.Data;

import java.util.Date;

@Data
public class ImageOverviewResponse {

    private String id;
    private Date modifiedDate;
}
