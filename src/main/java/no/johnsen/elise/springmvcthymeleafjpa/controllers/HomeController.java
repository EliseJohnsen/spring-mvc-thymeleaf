package no.johnsen.elise.springmvcthymeleafjpa.controllers;

import no.johnsen.elise.springmvcthymeleafjpa.dao.EmployeeRepository;
import no.johnsen.elise.springmvcthymeleafjpa.dao.ProjectRepository;
import no.johnsen.elise.springmvcthymeleafjpa.entities.Employee;
import no.johnsen.elise.springmvcthymeleafjpa.entities.Project;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class HomeController {
  
  @Autowired
  private ProjectRepository projectRepository;
  
  @Autowired
  private EmployeeRepository employeeRepository;
  
  @GetMapping("/")
  public String displayHome(Model model) {
    List<Project> projects = projectRepository.findAll();
    model.addAttribute("projects", projects);
    
    List<Employee> employees = employeeRepository.findAll();
    model.addAttribute("employees", employees);
    
    return "main/home";}
}
