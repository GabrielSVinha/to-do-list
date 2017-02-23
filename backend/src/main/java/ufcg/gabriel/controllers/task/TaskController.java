package ufcg.gabriel.controllers.task;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javassist.tools.web.BadHttpRequest;
import ufcg.gabriel.models.task.Task;
import ufcg.gabriel.models.task.TaskRepository;

import java.util.Collection;
import java.util.List;

@CrossOrigin(maxAge = 3600)
@RestController
@RequestMapping(value="/api/tasks")
public class TaskController {
    @Autowired
    private TaskRepository repo;
    
    @RequestMapping(value = "", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<List<Task>> getTasks(){
        return new ResponseEntity<>(this.repo.findAll(), HttpStatus.OK);
    }
    
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<Task> getTaskById(@PathVariable Long id){
    	System.out.println(repo.findOne(id)); //isso tem que sair cara
    	Task t = repo.findOne(id);
    	if(t == null){
    		return new ResponseEntity<Task>(HttpStatus.BAD_REQUEST);
    	}
    	return new ResponseEntity<Task>(t, HttpStatus.OK);
    }
    
    @RequestMapping(value = "/status",method = RequestMethod.POST, produces="application/json")
    @ResponseBody
    public ResponseEntity<?> updateTasks(@RequestBody String id, String status){
    	Task t = this.repo.findOne(Long.valueOf(id));
    	System.out.println(t);
    	if(t == null){
    		return new ResponseEntity(HttpStatus.BAD_REQUEST);
    	}else{
    		try{
        		t.setCompleted(parseBoolean(status));
    		}catch(Exception e){
    			e.printStackTrace();
    		}
        	this.repo.saveAndFlush(t);
        	System.out.println("Updated "+t.getName()+", for status: "+t.isCompleted());
        	return new ResponseEntity(HttpStatus.OK);
    	}
    }
    
    private boolean parseBoolean(String st) throws Exception{
    	if(st == null){
    		throw new BadHttpRequest();
    	}else if(st.equalsIgnoreCase("true")){
    		return true;
    	}else if(st.equalsIgnoreCase("false")){
    		return false;
    	}else{
    		throw new BadHttpRequest();
    	}
    }
    
    public void validate(String name) throws Exception{
        if(name == null || name.equals("")){
            throw new Exception("Name cannot be nil");
        }
    }
}