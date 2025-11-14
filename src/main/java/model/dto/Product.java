package model.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Product {
    private String id;
    private String description;
    private String category;
    private String size;
    private int qtyInStock;
    private double price;
}
