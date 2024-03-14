package dev.InnocentUdo.DTO.request;

import dev.InnocentUdo.model.Address;
import lombok.Data;

@Data
public class OrderRequest {
    private Long restaurantId;
    private Address deliveryAddress;
}
