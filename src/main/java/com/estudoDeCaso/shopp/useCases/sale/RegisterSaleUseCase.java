package com.estudoDeCaso.shopp.useCases.sale;

import com.estudoDeCaso.shopp.dto.product.ProductRequestDto;
import com.estudoDeCaso.shopp.dto.sale.SaleRequestDto;
import com.estudoDeCaso.shopp.entities.Employee;
import com.estudoDeCaso.shopp.entities.Product;
import com.estudoDeCaso.shopp.entities.Sale;
import com.estudoDeCaso.shopp.entities.StockHistory;
import com.estudoDeCaso.shopp.entities.enums.ChangeType;
import com.estudoDeCaso.shopp.exceptions.InvalidRequestException;
import com.estudoDeCaso.shopp.exceptions.NotFoundException;
import com.estudoDeCaso.shopp.repositories.EmployeeRepository;
import com.estudoDeCaso.shopp.repositories.ProductRepository;
import com.estudoDeCaso.shopp.repositories.SaleRepository;
import com.estudoDeCaso.shopp.repositories.StockHistoryRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class RegisterSaleUseCase {

    private final SaleRepository saleRepository;
    private final StockHistoryRepository stockHistoryRepository;
    private final ProductRepository productRepository;
    private final EmployeeRepository employeeRepository;

    public void execute(Long employeeId, SaleRequestDto saleRequestDto) {
        Employee employee = findEmployeeById(employeeId);
        List<Product> soldProducts = processSale(saleRequestDto);
        saveSale(employee, soldProducts);
    }

    private Employee findEmployeeById(Long employeeId) {
        return employeeRepository.findById(employeeId)
                .orElseThrow(() -> new NotFoundException("Employee not found"));
    }

    private List<Product> processSale(SaleRequestDto saleRequestDto) {
        return saleRequestDto.getProducts().stream()
                .map(this::processProductSale)
                .collect(Collectors.toList());
    }

    private Product processProductSale(ProductRequestDto productRequestDto) {
        Product product = productRepository.findProductByName(productRequestDto.getName())
                .orElseThrow(() -> new NotFoundException("Product not found"));

        int quantitySold = productRequestDto.getQuantity();

        if (product.getQuantity() < quantitySold) {
            throw new InvalidRequestException("Insufficient stock for product: " + product.getName());
        }

        updateProductStock(product, quantitySold);
        createStockHistory(product, quantitySold);
        return product;
    }

    private void updateProductStock(Product product, int quantitySold) {
        product.setQuantity(product.getQuantity() - quantitySold);
        productRepository.save(product);
    }

    private void createStockHistory(Product product, int quantitySold) {
        StockHistory stockHistory = new StockHistory();
        stockHistory.setProduct(product);
        stockHistory.setQuantityChange(-quantitySold);
        stockHistory.setChangeType(ChangeType.SALE);
        stockHistory.setChangeDate(LocalDateTime.now());
        stockHistoryRepository.save(stockHistory);
    }

    private void saveSale(Employee employee, List<Product> soldProducts) {
        Sale sale = new Sale();
        sale.setProductList(soldProducts);
        sale.setEmployee(employee);
        saleRepository.save(sale);
    }
}
