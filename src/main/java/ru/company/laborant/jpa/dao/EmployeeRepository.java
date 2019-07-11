package ru.company.laborant.jpa.dao;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import ru.company.laborant.jpa.domain.Employee;

public interface EmployeeRepository extends JpaRepository<Employee,Long> {
    List<Employee> findAllByFullNameContainingIgnoreCaseOrAddressContainingIgnoreCaseOrPhoneContainingIgnoreCaseOrPostIndexContainingIgnoreCaseOrDescriptionContainingIgnoreCase(String s1, String s2, String s3, String s4, String s5);
}
