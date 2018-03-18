package at.kuchel.api;

import lombok.Data;

import java.time.LocalDate;

@Data
public class ImageOverviewResponse {

    private String id;
    private LocalDate modifiedDate;
}
