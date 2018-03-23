package at.kuchel.api;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
public class LastSyncDateRequest {

    @ApiModelProperty(required = true)
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    private Date lastSyncDate;

}


