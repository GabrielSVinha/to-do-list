package ufcg.gabriel.tasks;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class TaskController {

	@Autowired
	private CompletedTasksRepository repository;
	
	public TaskController() { 
	}
	
	@RequestMapping("/tasks")
	String tasks (Model model){
		
		model.addAttribute("tasks", repository.findAll());
		
		return "tasks";
	}
	
}
