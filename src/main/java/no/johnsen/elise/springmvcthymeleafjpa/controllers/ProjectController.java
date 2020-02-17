package no.johnsen.elise.springmvcthymeleafjpa.controllers;

import no.johnsen.elise.springmvcthymeleafjpa.dao.EmployeeRepository;
import no.johnsen.elise.springmvcthymeleafjpa.dao.ProjectRepository;
import no.johnsen.elise.springmvcthymeleafjpa.entities.Employee;
import no.johnsen.elise.springmvcthymeleafjpa.entities.Project;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/projects")
public class ProjectController {
  
  @Autowired
  ProjectRepository projectRepository;
  
  @Autowired
  EmployeeRepository employeeRepository;
  
  @GetMapping
  public String displayProjects(Model model) {
    List<Project> projects = projectRepository.findAll();
    model.addAttribute("projects", projects);
    return "projects/list-projects";
  }
  
  @GetMapping("/new")
  public String displayProjectForm(Model model) {
    
    Project aProject = new Project();
    model.addAttribute("project", aProject);
    List<Employee> employees = employeeRepository.findAll();
    
    model.addAttribute("allEmployees", employees);
    return "projects/new-project";
  }
  
  @PostMapping("/save")
  public String createProject(Project project, @RequestParam List<Long> employees, Model model) {
    projectRepository.save(project);
    
    Iterable<Employee> chosenEmployees = employeeRepository.findAllById(employees);
    
    for(Employee employee : chosenEmployees) {
      employee.setProject(project);
      employeeRepository.save(employee);
    }
    
    return "redirect:/projects/new";
  }
}
