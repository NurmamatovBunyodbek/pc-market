package uz.pdp.pcmarket.payload;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrdersDto {

    private Integer basketId;
    private boolean isClaimed;
    private boolean isCanceled;
}
