package model.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Staff {
    private String id;
    private String name;
    private String address;
    private String position;
    private double salary;
    private LocalDate joinDate;
}
