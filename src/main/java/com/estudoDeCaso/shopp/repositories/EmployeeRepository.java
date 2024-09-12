package com.estudoDeCaso.shopp.repositories;

import com.estudoDeCaso.shopp.entities.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    boolean existsByCpf(String cpf);
    Optional<Employee> findEmployeeByEmail(String email);
}
