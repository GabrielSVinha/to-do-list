package ufcg.gabriel;

import java.util.Arrays;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ImportResource;

import ufcg.gabriel.models.task.Task;
import ufcg.gabriel.models.task.TaskRepository;

@SpringBootApplication
public class ToDoListApplication {
	public static void main(String[] args) {
		SpringApplication.run(ToDoListApplication.class, args);
	}
	
	@Bean
	CommandLineRunner runner (TaskRepository repo){
		return args -> {
			Task t1 = new Task("LSD");
			Task t2 = new Task("SPLAB");
			Task t3 = new Task("LAB3");
			repo.save(t1);
			repo.save(t2);
			repo.save(t3);
			repo.findAll().forEach(t -> System.out.println(t.getId()));
		};
	}
}
