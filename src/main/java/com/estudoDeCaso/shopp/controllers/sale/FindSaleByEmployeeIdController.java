package com.estudoDeCaso.shopp.controllers.sale;

import com.estudoDeCaso.shopp.dto.sale.SaleResponseDto;
import com.estudoDeCaso.shopp.useCases.sale.FindSaleByEmployeeIdUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/sale")
@RequiredArgsConstructor
public class FindSaleByEmployeeIdController {

    private final FindSaleByEmployeeIdUseCase findSaleByEmployeeId;

    @GetMapping("/{id}")
    public ResponseEntity<List<SaleResponseDto>> findSaleByEmployeeId(@PathVariable Long id){
        List<SaleResponseDto> responseDtoList = this.findSaleByEmployeeId.execute(id);
        return ResponseEntity.ok(responseDtoList);
    }
}
