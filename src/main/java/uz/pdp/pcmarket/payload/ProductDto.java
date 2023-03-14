package uz.pdp.pcmarket.payload;

import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import uz.pdp.pcmarket.entity.Category;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductDto {

    private String name;
    private Double price;

    private Integer categoryId;
}
