package at.kuchel.api;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.util.Date;

@Data
@JsonInclude(value = JsonInclude.Include.NON_EMPTY)
public class ErrorResponse {

    private Date timestamp;
    private Integer status;
    private String error;
    private String exception;
    private String message;
}
