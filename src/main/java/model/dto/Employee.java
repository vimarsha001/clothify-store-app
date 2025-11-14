package model.dto;


import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Employee {
    private String id;
    private String name;
    private String email;
    private String phoneNumber;
    private String position;
    private double salary;
    private LocalDate joinDate;
}
