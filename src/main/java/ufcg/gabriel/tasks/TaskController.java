package ufcg.gabriel.tasks;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TaskController {

	@Autowired
	private CompletedTasksRepository repository;
	
	public TaskController() { 
	}
	
	@RequestMapping("/tasks")
	Collection<Task> tasks(){
		return this.repository.findAll();
	}
	
}
