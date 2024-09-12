package com.estudoDeCaso.shopp.dto.employee;

import com.estudoDeCaso.shopp.dto.sale.SaleResponseDto;
import com.estudoDeCaso.shopp.entities.enums.Roles;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeResponseDto {

    private Long id;
    private String name;
    private String cpf;
    private String email;
    private String phone;
    private String address;
    private LocalDateTime birthDate;
    private Double wage;
    private List<Roles> roles;
}
