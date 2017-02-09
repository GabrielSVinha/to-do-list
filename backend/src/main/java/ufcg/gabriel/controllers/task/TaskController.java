package ufcg.gabriel.controllers.task;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import ufcg.gabriel.models.task.Task;
import ufcg.gabriel.models.task.TaskRepository;

import java.util.Collection;

@RestController
public class TaskController {

    @Autowired
    private TaskRepository repo;

    @RequestMapping(value = "tasks", method = RequestMethod.GET)
    public Collection<Task> getTasks(){
        return repo.findAll();
    }

    public void validate(String name) throws Exception{
        if(name == null || name.equals("")){
            throw new Exception("Name cannot be nil");
        }
    }

}
