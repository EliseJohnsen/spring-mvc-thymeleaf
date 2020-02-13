package no.johnsen.elise.springmvcthymeleafjpa.dao;

import no.johnsen.elise.springmvcthymeleafjpa.entities.Employee;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface EmployeeRepository extends CrudRepository<Employee, Long> {
  
  @Override
  public List<Employee> findAll();
}
