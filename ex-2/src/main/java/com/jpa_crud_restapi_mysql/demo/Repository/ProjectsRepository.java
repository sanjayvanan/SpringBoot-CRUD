package com.jpa_crud_restapi_mysql.demo.Repository;
import com.jpa_crud_restapi_mysql.demo.Model.Projects;
import org.springframework.data.repository.CrudRepository;

public interface ProjectsRepository extends CrudRepository<Projects, Integer>{

}
