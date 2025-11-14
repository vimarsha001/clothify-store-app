package model.dto;

import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Order {
    private String id;
    private String custId;
    private int qty;
    private double total;
    private String status;
    private String address;
    private LocalDate date;
}
