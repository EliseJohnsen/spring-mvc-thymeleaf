package no.johnsen.elise.springmvcthymeleafjpa.dao;

import no.johnsen.elise.springmvcthymeleafjpa.entities.Project;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ProjectRepository extends CrudRepository<Project, Long> {

  @Override
  public List<Project> findAll();

}
