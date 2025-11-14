package model.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Supplier {
    private String id;
    private String name;
    private String productId;
    private String category;
    private int qty;
}
