package com.jpa_crud_restapi_mysql.demo.Controller;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.jpa_crud_restapi_mysql.demo.Model.Projects;
import com.jpa_crud_restapi_mysql.demo.Repository.ProjectsRepository;

@RestController
public class ProjectsController {
	@Autowired
	private ProjectsRepository prorep;
	@PostMapping("/insertproject")
	public String createpro(@RequestBody Projects pro)
	{
		prorep.save(pro);
		return "inserted";
	}
	@PutMapping("/updateproject/{id}")
	public String updatepro(@PathVariable int id, @RequestBody Projects pro)
	{
		pro.setId(id);
		prorep.save(pro);
		return "Updated";
	}
	@GetMapping("/projects")
	public List<Projects> getEmp()
	{
		return (List<Projects>) prorep.findAll();
	}
	@GetMapping("/getproject/{id}")
	public Optional<Projects> getById(@PathVariable int id)
	{
		return prorep.findById(id);
	}
	@DeleteMapping("/del_project/{id}")
	public String deletepro(@PathVariable int id)
	{
		prorep.deleteById(id);
		return "deleted";
}
}