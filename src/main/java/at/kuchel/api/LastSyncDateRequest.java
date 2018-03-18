package at.kuchel.api;

import lombok.Data;
import org.hibernate.validator.constraints.NotEmpty;

import java.util.ArrayList;
import java.util.List;

@Data
public class LastSyncDateRequest {

    @NotEmpty
    List<String> redeemVoucherCodes = new ArrayList<>();
}


