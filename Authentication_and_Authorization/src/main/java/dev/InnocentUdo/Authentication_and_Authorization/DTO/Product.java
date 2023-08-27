package dev.InnocentUdo.Authentication_and_Authorization.DTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Product {

    private int productId;
    private String name;
    private int quantity;
    private double price;
}
