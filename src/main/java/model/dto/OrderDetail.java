package model.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class OrderDetail {
    private String id;
    private String prod_id;
    private int qty;
    private double total;
}
