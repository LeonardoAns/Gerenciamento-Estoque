package com.estudoDeCaso.shopp.dto.employee;

import com.estudoDeCaso.shopp.entities.enums.Roles;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeRequestDto {

    private String name;
    private String cpf;
    private String password;
    private String email;
    private String phone;
    private String address;
    private LocalDateTime birthDate;
    private Double wage;
    private List<Roles> roles;
}
