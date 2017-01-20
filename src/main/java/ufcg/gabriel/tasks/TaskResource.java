package ufcg.gabriel.tasks;

import org.springframework.hateoas.Link;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.ResourceProcessor;
import org.springframework.stereotype.Component;

@Component
public class TaskResource implements ResourceProcessor<Resource<Task>>{

	@Override
	public Resource<Task> process(Resource<Task> arg0) {
		
		arg0.add(new Link(""));
		
		return arg0;
	}

}
